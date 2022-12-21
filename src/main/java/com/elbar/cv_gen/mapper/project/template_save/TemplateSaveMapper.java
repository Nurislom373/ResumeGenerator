package com.elbar.cv_gen.mapper.project.template_save;

import com.elbar.cv_gen.dto.project.template_save.TemplateSaveCreateDTO;
import com.elbar.cv_gen.dto.project.template_save.TemplateSaveDetailDTO;
import com.elbar.cv_gen.dto.project.template_save.TemplateSaveGetDTO;
import com.elbar.cv_gen.dto.project.template_save.TemplateSaveUpdateDTO;
import com.elbar.cv_gen.entity.project.template_save.TemplateSaveEntity;
import com.elbar.cv_gen.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface TemplateSaveMapper extends GenericMapper<TemplateSaveCreateDTO, TemplateSaveUpdateDTO, TemplateSaveGetDTO, TemplateSaveEntity> {

    TemplateSaveEntity toDetailDTO(TemplateSaveDetailDTO DTO);

    TemplateSaveDetailDTO fromDetailDTO(TemplateSaveEntity entity);


}
