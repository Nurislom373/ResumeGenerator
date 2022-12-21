package com.elbar.cv_gen.service.auth.auth_block;

import com.elbar.cv_gen.criteria.auth.auth_block.AuthBlockCriteria;
import com.elbar.cv_gen.dto.auth.auth_block.AuthBlockCreateDTO;
import com.elbar.cv_gen.dto.auth.auth_block.AuthBlockDetailDTO;
import com.elbar.cv_gen.dto.auth.auth_block.AuthBlockGetDTO;
import com.elbar.cv_gen.entity.auth.auth_block.AuthBlockEntity;
import com.elbar.cv_gen.exception.exception.NotFoundException;
import com.elbar.cv_gen.mapper.auth.auth_block.AuthBlockMapper;
import com.elbar.cv_gen.repository.auth.auth_block.AuthBlockRepository;
import com.elbar.cv_gen.service.AbstractService;
import com.elbar.cv_gen.service.auth.blocked_for.BlockedForService;
import com.elbar.cv_gen.utils.BaseUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthBlockServiceImpl extends AbstractService<AuthBlockMapper, AuthBlockRepository>
        implements AuthBlockService {

    private final BlockedForService blockedForService;

    public AuthBlockServiceImpl(AuthBlockMapper mapper, AuthBlockRepository repository, BlockedForService blockedForService) {
        super(mapper, repository);
        this.blockedForService = blockedForService;
    }

    @Override
    public void create(AuthBlockCreateDTO dto) {
        if (repository.existsByUserIdEquals(dto.getUserId())) {
            throw new RuntimeException("This user already blocked!");
        }
        AuthBlockEntity authBlockEntity = mapper.toCreateDTO(dto);
        Integer min = blockedForService.blockCodeGetMin(dto.getBlockedFor());
        authBlockEntity.setDuration(BaseUtils.plusMin(min));
        repository.save(authBlockEntity);
    }

    @Override
    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Auth Blocked not found");
        }
        repository.deleteById(id);
    }

    @Override
    public AuthBlockGetDTO get(Integer id) {
        return mapper.fromGetDTO(
                repository.findById(id)
                        .orElseThrow(() -> {
                            throw new NotFoundException("Auth Blocked not found");
                        }));
    }


    @Override
    public AuthBlockDetailDTO detail(Integer id) {
        return mapper.fromDetailDTO(
                repository.findById(id)
                        .orElseThrow(() -> {
                            throw new NotFoundException("Auth Blocked not found");
                        }));
    }

    @Override
    public boolean userIdBlocked(Integer id) {
        AuthBlockEntity entity = repository.findByUserId(id)
                .orElse(null);
        if (entity == null) {
            return true;
        } else {
            return entity.isDeleted();
        }
    }

    @Override
    public List<AuthBlockGetDTO> list(AuthBlockCriteria criteria) {
        return repository.findAll(PageRequest.of(criteria.getPage(),
                        criteria.getSize()))
                .stream()
                .map(mapper::fromGetDTO)
                .toList();
    }
}
