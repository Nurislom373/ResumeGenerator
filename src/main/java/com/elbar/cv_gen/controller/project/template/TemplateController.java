package com.elbar.cv_gen.controller.project.template;

import com.elbar.cv_gen.controller.GenericCUDController;
import com.elbar.cv_gen.controller.GenericGLController;
import com.elbar.cv_gen.controller.GenericSpecificationController;
import com.elbar.cv_gen.criteria.BetweenCriteria;
import com.elbar.cv_gen.criteria.SearchCriteria;
import com.elbar.cv_gen.criteria.project.template.TemplateCriteria;
import com.elbar.cv_gen.dto.project.template.TemplateCreateDTO;
import com.elbar.cv_gen.dto.project.template.TemplateGetDTO;
import com.elbar.cv_gen.dto.project.template.TemplateUpdateDTO;

public interface TemplateController extends GenericCUDController<TemplateCreateDTO, TemplateUpdateDTO, Integer>, GenericGLController<TemplateGetDTO, TemplateCriteria, Integer>, GenericSpecificationController<SearchCriteria, BetweenCriteria, TemplateGetDTO> {
}
