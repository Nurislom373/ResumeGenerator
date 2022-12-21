package com.elbar.cv_gen.service.auth.auth_user;

import com.elbar.cv_gen.criteria.BetweenCriteria;
import com.elbar.cv_gen.criteria.SearchCriteria;
import com.elbar.cv_gen.criteria.auth.auth_user.AuthUserCriteria;
import com.elbar.cv_gen.dto.auth.auth_user.*;
import com.elbar.cv_gen.entity.auth.auth_user.AuthUserEntity;
import com.elbar.cv_gen.service.BaseService;
import com.elbar.cv_gen.service.GenericCUDService;
import com.elbar.cv_gen.service.GenericGLService;
import com.elbar.cv_gen.service.GenericSpecificationService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthUserService extends GenericCUDService<AuthUserCreateDTO, AuthUserUpdateDTO, Integer>,
        GenericGLService<AuthUserGetDTO, AuthUserCriteria, Integer>,
        GenericSpecificationService<SearchCriteria, BetweenCriteria, AuthUserGetDTO>,
        UserDetailsService,
        BaseService {

    AuthUserDetailDTO detail(Integer id);

    Object login(AuthUserRequestDTO dto);

    void changePassword(AuthUserChangePasswordDTO dto);

    boolean existById(Integer id);

    AuthUserEntity getEntity(Integer id);

    AuthUserEntity getEntityIsNotBlocked(Integer id);

    boolean existByIdAndIsNotBlocked(Integer id);
}
