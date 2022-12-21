package com.elbar.cv_gen.mapper.project.template;

import com.elbar.cv_gen.dto.project.template.TemplateCreateDTO;
import com.elbar.cv_gen.dto.project.template.TemplateGetDTO;
import com.elbar.cv_gen.dto.project.template.TemplateUpdateDTO;
import com.elbar.cv_gen.entity.project.template.TemplateEntity;
import com.elbar.cv_gen.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface TemplateMapper extends GenericMapper<TemplateCreateDTO, TemplateUpdateDTO, TemplateGetDTO, TemplateEntity> {
    @Override
    default TemplateGetDTO fromGetDTO(TemplateEntity entity) {
        try {
            return new TemplateGetDTO(entity.getTitle(), entity.getHtml(), entity.getFields(), entity.getCategoryId(), entity.getImagePath(), entity.getPrice(), entity.getDownloadCount(), entity.getIsPremium(), entity.getIsActive());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    default TemplateEntity toUpdateDTO(TemplateUpdateDTO dto) {
        return new TemplateEntity(dto.getTitle(), dto.getHtml(), dto.getFields(), dto.getCategoryId(), dto.getImagePath(), dto.getPrice(), dto.getDownloadCount(), dto.getIsPremium(), dto.getIsActive());
    }

    @Override
    default TemplateUpdateDTO fromUpdateDTO(TemplateEntity entity) {
        return new TemplateUpdateDTO(entity.getTitle(), entity.getHtml(), entity.getFields(), entity.getCategoryId(), entity.getImagePath(), entity.getPrice(), entity.getDownloadCount(), entity.getIsPremium(), entity.getIsActive());
    }

    @Override
    default TemplateEntity toGetDTO(TemplateGetDTO dto) {
        return new TemplateEntity(dto.getTitle(), dto.getHtml(), dto.getFields(), dto.getCategoryId(), dto.getImagePath(), dto.getPrice(), dto.getDownloadCount(), dto.getIsPremium(), dto.getIsActive());
    }
}
