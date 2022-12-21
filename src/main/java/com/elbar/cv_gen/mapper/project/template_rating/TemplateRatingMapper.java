package com.elbar.cv_gen.mapper.project.template_rating;

import com.elbar.cv_gen.dto.project.template_rating.TemplateRatingCreateDTO;
import com.elbar.cv_gen.dto.project.template_rating.TemplateRatingGetDTO;
import com.elbar.cv_gen.dto.project.template_rating.TemplateRatingUpdateDTO;
import com.elbar.cv_gen.entity.project.template_rating.TemplateRatingEntity;
import com.elbar.cv_gen.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface TemplateRatingMapper extends GenericMapper<TemplateRatingCreateDTO, TemplateRatingUpdateDTO, TemplateRatingGetDTO, TemplateRatingEntity> {
}
