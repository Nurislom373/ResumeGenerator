package com.elbar.cv_gen.mapper.auth.auth_block;

import com.elbar.cv_gen.dto.GenericDTO;
import com.elbar.cv_gen.dto.auth.auth_block.AuthBlockCreateDTO;
import com.elbar.cv_gen.dto.auth.auth_block.AuthBlockDetailDTO;
import com.elbar.cv_gen.dto.auth.auth_block.AuthBlockGetDTO;
import com.elbar.cv_gen.entity.auth.auth_block.AuthBlockEntity;
import com.elbar.cv_gen.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AuthBlockMapper extends GenericMapper<AuthBlockCreateDTO, GenericDTO, AuthBlockGetDTO, AuthBlockEntity> {

    AuthBlockEntity toDetailDTO(AuthBlockDetailDTO DTO);

    AuthBlockDetailDTO fromDetailDTO(AuthBlockEntity entity);

}
