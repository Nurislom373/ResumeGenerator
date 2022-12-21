package com.elbar.cv_gen.controller.project.template_rating;

import com.elbar.cv_gen.controller.GenericCUDController;
import com.elbar.cv_gen.controller.GenericGLController;
import com.elbar.cv_gen.controller.GenericSpecificationController;
import com.elbar.cv_gen.criteria.BetweenCriteria;
import com.elbar.cv_gen.criteria.SearchCriteria;
import com.elbar.cv_gen.criteria.project.template_rating.TemplateRatingCriteria;
import com.elbar.cv_gen.dto.project.template_rating.TemplateRatingCreateDTO;
import com.elbar.cv_gen.dto.project.template_rating.TemplateRatingGetDTO;
import com.elbar.cv_gen.dto.project.template_rating.TemplateRatingUpdateDTO;

public interface TemplateRatingController extends GenericCUDController<TemplateRatingCreateDTO, TemplateRatingUpdateDTO, Integer>, GenericGLController<TemplateRatingGetDTO, TemplateRatingCriteria, Integer>, GenericSpecificationController<SearchCriteria, BetweenCriteria, TemplateRatingGetDTO> {
}
