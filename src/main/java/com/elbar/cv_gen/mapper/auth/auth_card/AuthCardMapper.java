package com.elbar.cv_gen.mapper.auth.auth_card;

import com.elbar.cv_gen.dto.auth.auth_card.AuthCardCreateDto;
import com.elbar.cv_gen.dto.auth.auth_card.AuthCardDto;
import com.elbar.cv_gen.dto.auth.auth_card.AuthCardUpdateDto;
import com.elbar.cv_gen.entity.auth.auth_card.AuthCardEntity;
import com.elbar.cv_gen.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AuthCardMapper extends GenericMapper<AuthCardCreateDto, AuthCardUpdateDto, AuthCardDto, AuthCardEntity> {

}
