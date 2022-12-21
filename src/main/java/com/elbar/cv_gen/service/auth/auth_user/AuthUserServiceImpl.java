package com.elbar.cv_gen.service.auth.auth_user;

import com.elbar.cv_gen.annotation.IdConstraint;
import com.elbar.cv_gen.configs.encryption.PasswordEncoderConfigurer;
import com.elbar.cv_gen.criteria.BetweenCriteria;
import com.elbar.cv_gen.criteria.SearchCriteria;
import com.elbar.cv_gen.criteria.auth.auth_user.AuthUserCriteria;
import com.elbar.cv_gen.dto.auth.auth_user.*;
import com.elbar.cv_gen.entity.auth.auth_user.AuthUserEntity;
import com.elbar.cv_gen.enums.auth.role.RolesEnum;
import com.elbar.cv_gen.enums.auth.status.StatusEnum;
import com.elbar.cv_gen.exception.exception.InvalidValidationException;
import com.elbar.cv_gen.exception.exception.NotFoundException;
import com.elbar.cv_gen.mapper.auth.auth_user.AuthUserMapper;
import com.elbar.cv_gen.repository.auth.auth_user.AuthUserRepository;
import com.elbar.cv_gen.service.AbstractService;
import com.elbar.cv_gen.service.auth.auth_block.AuthBlockService;
import com.elbar.cv_gen.specification.auth.auth_user.AuthUserBetweenSpecification;
import com.elbar.cv_gen.specification.auth.auth_user.AuthUserSearchSpecification;
import com.elbar.cv_gen.utils.BaseUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class AuthUserServiceImpl extends AbstractService<AuthUserMapper, AuthUserRepository> implements AuthUserService {

    private final PasswordEncoderConfigurer encoderConfigurer;
    private final AuthBlockService blockService;

    public AuthUserServiceImpl(AuthUserMapper mapper, AuthUserRepository repository, PasswordEncoderConfigurer encoderConfigurer, AuthBlockService blockService) {
        super(mapper, repository);
        this.encoderConfigurer = encoderConfigurer;
        this.blockService = blockService;
    }

    @Override
    public void create(AuthUserCreateDTO dto) {
        if (repository.existsByPhoneEquals(dto.getPhone())) {
            throw new RuntimeException("This phone number already created!");
        }
        AuthUserEntity authUserEntity = mapper.toCreateDTO(dto);
        authUserEntity.setRole(RolesEnum.USER);
        authUserEntity.setPassword(new PasswordEncoderConfigurer().encoder().encode(dto.getPassword()));
        authUserEntity.setStatus(StatusEnum.NO_ACTIVE);
        authUserEntity.setDownloadCount(0);
        authUserEntity.setLoginTryCount(0);
        repository.save(authUserEntity);
    }

    @Override
    public void update(AuthUserUpdateDTO dto) {
        AuthUserEntity entity = repository.findById(dto.getId())
                .orElseThrow(() -> {
                    throw new NotFoundException("User not found");
                });
        BeanUtils.copyProperties(dto, entity);
        entity.setUpdatedAt(LocalDateTime.now());
        entity.setUpdatedBy(dto.getId());
        repository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("User not found");
        }
        repository.deleteById(id);
    }

    @Override
    public AuthUserGetDTO get(Integer id) {
        return mapper.fromGetDTO(
                repository.findById(id)
                        .orElseThrow(() -> {
                            throw new NotFoundException("User not found");
                        }));
    }

    @Override
    public AuthUserDetailDTO detail(Integer id) {
        return mapper.fromDetailDTO(
                repository.findById(id)
                        .orElseThrow(() -> {
                            throw new NotFoundException("User not found");
                        }));
    }

    @Override
    public Object login(AuthUserRequestDTO dto) {
        HttpEntity<AuthUserRequestDTO> entity = new HttpEntity<>(dto);
        ResponseEntity<Object> exchange = BaseUtils.REST_TEMPLATE.exchange("http://localhost:8080/api/v1/login", HttpMethod.POST, entity, Object.class);
        return exchange.getBody();
    }

    @Override
    public void changePassword(AuthUserChangePasswordDTO dto) {
        AuthUserEntity entity = repository.findById(dto.getUserId())
                .orElseThrow(() -> {
                    throw new NotFoundException("Auth User not found");
                });
        if (!encoderConfigurer.encoder().matches(dto.getOldPwd(), entity.getPassword())) {
            throw new InvalidValidationException("Invalid Old Password!");
        }
        entity.setPassword(encoderConfigurer.encoder().encode(dto.getNewPwd()));
        entity.setUpdatedAt(LocalDateTime.now());
        entity.setUpdatedBy(dto.getUserId());
        repository.save(entity);
    }

    @Override
    public boolean existById(@IdConstraint Integer id) {
        return repository.existsById(id);
    }

    @Override
    public AuthUserEntity getEntity(Integer id) {
        if (Objects.isNull(id) || id < 1) {
            throw new InvalidValidationException("Invalid ID!");
        }
        return repository.findById(id)
                .orElseThrow(() -> {
                    throw new NotFoundException("Auth User not found");
                });
    }

    @Override
    public AuthUserEntity getEntityIsNotBlocked(Integer id) {
        AuthUserEntity entity = repository.findById(id).
                orElseThrow(() -> {
                    throw new NotFoundException("Auth User not found");
                });
        if (blockService.userIdBlocked(entity.getId())) {
            throw new RuntimeException("User is blocked");
        }
        return entity;
    }

    @Override
    public boolean existByIdAndIsNotBlocked(Integer id) {
        if (Objects.isNull(id) || id < 1) {
            throw new InvalidValidationException("Invalid ID!");
        }
        if (!repository.existsById(id)) {
            throw new NotFoundException("Auth User not found");
        }
        return blockService.userIdBlocked(id);
    }

    @Override
    public List<AuthUserGetDTO> list(AuthUserCriteria criteria) {
        return repository.findAll(PageRequest.of(criteria.getPage(), criteria.getSize(),
                        criteria.getSort(), criteria.getFieldsEnum().getValue()))
                .stream()
                .map(mapper::fromGetDTO)
                .toList();
    }


    @Override
    public List<AuthUserGetDTO> list_with_search(SearchCriteria criteria) {
        return repository.findAll(new AuthUserSearchSpecification(criteria),
                        PageRequest.of(criteria.getPage(),
                                criteria.getSize()))
                .stream()
                .map(mapper::fromGetDTO)
                .toList();
    }

    @Override
    public List<AuthUserGetDTO> list_with_between(BetweenCriteria criteria) {
        return repository.findAll(new AuthUserBetweenSpecification(criteria),
                        PageRequest.of(criteria.getPage(),
                                criteria.getSize()))
                .stream()
                .map(mapper::fromGetDTO)
                .toList();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUserEntity entity = repository.findByPhoneEquals(username)
                .orElseThrow(() -> {
                    throw new NotFoundException("User not found");
                });
        return User.builder()
                .username(entity.getPhone())
                .password(entity.getPassword())
                .authorities(entity.getRole().getValue())
                .accountLocked(false)
                .accountExpired(false)
                .disabled(false)
                .credentialsExpired(false)
                .build();
    }

    private boolean checkId(Integer id) {
        if (Objects.isNull(id) || id < 1) {
            throw new InvalidValidationException("Invalid ID!");
        }
        return true;
    }
}
