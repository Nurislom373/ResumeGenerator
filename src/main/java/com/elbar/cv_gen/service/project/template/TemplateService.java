package com.elbar.cv_gen.service.project.template;

import com.elbar.cv_gen.criteria.BetweenCriteria;
import com.elbar.cv_gen.criteria.SearchCriteria;
import com.elbar.cv_gen.criteria.project.template.TemplateCriteria;
import com.elbar.cv_gen.dto.project.template.TemplateCreateDTO;
import com.elbar.cv_gen.dto.project.template.TemplateGetDTO;
import com.elbar.cv_gen.dto.project.template.TemplateTiDTO;
import com.elbar.cv_gen.dto.project.template.TemplateUpdateDTO;
import com.elbar.cv_gen.entity.project.template.TemplateEntity;
import com.elbar.cv_gen.service.GenericCUDService;
import com.elbar.cv_gen.service.GenericGLService;
import com.elbar.cv_gen.service.GenericSpecificationService;

import java.util.List;

public interface TemplateService extends GenericCUDService<TemplateCreateDTO, TemplateUpdateDTO, Integer>, GenericGLService<TemplateGetDTO, TemplateCriteria, Integer>, GenericSpecificationService<SearchCriteria, BetweenCriteria, TemplateGetDTO> {

    TemplateEntity getEntity(Integer id);

    boolean existById(Integer id);

    List<TemplateTiDTO> tiTemplates(TemplateCriteria criteria);
}
