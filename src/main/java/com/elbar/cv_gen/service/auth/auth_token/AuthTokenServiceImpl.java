package com.elbar.cv_gen.service.auth.auth_token;

import com.elbar.cv_gen.criteria.auth.auth_token.AuthTokenCriteria;
import com.elbar.cv_gen.dto.auth.auth_token.AuthTokenCreateDTO;
import com.elbar.cv_gen.dto.auth.auth_token.AuthTokenDetailDTO;
import com.elbar.cv_gen.dto.auth.auth_token.AuthTokenGetDTO;
import com.elbar.cv_gen.entity.auth.auth_token.AuthTokenEntity;
import com.elbar.cv_gen.mapper.auth.auth_token.AuthTokenMapper;
import com.elbar.cv_gen.repository.auth.auth_token.AuthTokenRepository;
import com.elbar.cv_gen.service.AbstractService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class AuthTokenServiceImpl extends AbstractService<AuthTokenMapper, AuthTokenRepository> implements AuthTokenService {

    public AuthTokenServiceImpl(AuthTokenMapper mapper, AuthTokenRepository repository) {
        super(mapper, repository);
    }

    @Override
    public void create(AuthTokenCreateDTO dto) {
        Optional<AuthTokenEntity> optional = repository.findByUserIdEqualsAndTypeEquals(dto.getUserId(),
                dto.getType());
        AuthTokenEntity authTokenEntity;
        if (optional.isPresent()) {
            authTokenEntity = optional.get();
            authTokenEntity.setToken(dto.getToken());
            authTokenEntity.setDuration(plusMin(dto.getMinDuration()));
            authTokenEntity.setUpdatedAt(LocalDateTime.now());
            authTokenEntity.setUpdatedBy(dto.getUserId());
        } else {
            authTokenEntity = mapper.toCreateDTO(dto);
            authTokenEntity.setDuration(plusMin(dto.getMinDuration()));
            authTokenEntity.setCreatedBy(dto.getUserId());
        }
        repository.save(authTokenEntity);
    }

    @Override
    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Auth Token not found");
        }
        repository.deleteById(id);
    }

    @Override
    public AuthTokenGetDTO get(Integer id) {
        return mapper.fromGetDTO(
                repository.findById(id)
                        .orElseThrow(() -> {
                            throw new NotFoundException("Auth Token not found");
                        })
        );
    }

    @Override
    public AuthTokenDetailDTO detail(Integer id) {
        return mapper.fromDetailDTO(
                repository.findById(id)
                        .orElseThrow(() -> {
                            throw new NotFoundException("Auth Token not found");
                        })
        );
    }

    @Override
    public List<AuthTokenGetDTO> list(AuthTokenCriteria criteria) {
        return repository.findAll(
                        PageRequest.of(criteria.getPage(), criteria.getSize(), criteria.getSort(),
                                criteria.getFieldsEnum().getValue())
                ).stream()
                .map(mapper::fromGetDTO)
                .toList();
    }

    private Instant plusMin(Integer min) {
        return Instant.now().plusNanos(TimeUnit.MINUTES.toNanos(min));
    }
}
