package com.elbar.cv_gen.mapper.auth.auth_user;

import com.elbar.cv_gen.dto.auth.auth_user.AuthUserCreateDTO;
import com.elbar.cv_gen.dto.auth.auth_user.AuthUserDetailDTO;
import com.elbar.cv_gen.dto.auth.auth_user.AuthUserGetDTO;
import com.elbar.cv_gen.dto.auth.auth_user.AuthUserUpdateDTO;
import com.elbar.cv_gen.entity.auth.auth_user.AuthUserEntity;
import com.elbar.cv_gen.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AuthUserMapper extends GenericMapper<AuthUserCreateDTO, AuthUserUpdateDTO, AuthUserGetDTO, AuthUserEntity> {

    AuthUserEntity toDetailDTO(AuthUserDetailDTO DTO);

    AuthUserDetailDTO fromDetailDTO(AuthUserEntity entity);

}
