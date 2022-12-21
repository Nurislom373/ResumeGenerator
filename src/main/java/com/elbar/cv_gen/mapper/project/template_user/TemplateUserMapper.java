package com.elbar.cv_gen.mapper.project.template_user;

import com.elbar.cv_gen.dto.project.template_user.TemplateUserCreateDTO;
import com.elbar.cv_gen.dto.project.template_user.TemplateUserDetailDTO;
import com.elbar.cv_gen.dto.project.template_user.TemplateUserGetDTO;
import com.elbar.cv_gen.dto.project.template_user.TemplateUserUpdateDTO;
import com.elbar.cv_gen.entity.project.template_user.TemplateUserEntity;
import com.elbar.cv_gen.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface TemplateUserMapper extends GenericMapper<TemplateUserCreateDTO, TemplateUserUpdateDTO, TemplateUserGetDTO, TemplateUserEntity> {

    TemplateUserEntity toDetailDTO(TemplateUserDetailDTO DTO);

    TemplateUserDetailDTO fromDetailDTO(TemplateUserEntity entity);


}
