package com.elbar.cv_gen.mapper.auth.auth_token;

import com.elbar.cv_gen.dto.GenericDTO;
import com.elbar.cv_gen.dto.auth.auth_token.AuthTokenCreateDTO;
import com.elbar.cv_gen.dto.auth.auth_token.AuthTokenDetailDTO;
import com.elbar.cv_gen.dto.auth.auth_token.AuthTokenGetDTO;
import com.elbar.cv_gen.entity.auth.auth_token.AuthTokenEntity;
import com.elbar.cv_gen.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AuthTokenMapper extends GenericMapper<AuthTokenCreateDTO, GenericDTO, AuthTokenGetDTO, AuthTokenEntity> {

    AuthTokenEntity toDetailDTO(AuthTokenDetailDTO DTO);

    AuthTokenDetailDTO fromDetailDTO(AuthTokenEntity entity);

}
