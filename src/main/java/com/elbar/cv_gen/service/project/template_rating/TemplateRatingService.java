package com.elbar.cv_gen.service.project.template_rating;

import com.elbar.cv_gen.criteria.BetweenCriteria;
import com.elbar.cv_gen.criteria.SearchCriteria;
import com.elbar.cv_gen.criteria.project.template_rating.TemplateRatingCriteria;
import com.elbar.cv_gen.dto.project.template_rating.TemplateRatingCreateDTO;
import com.elbar.cv_gen.dto.project.template_rating.TemplateRatingGetDTO;
import com.elbar.cv_gen.dto.project.template_rating.TemplateRatingUpdateDTO;
import com.elbar.cv_gen.service.GenericCUDService;
import com.elbar.cv_gen.service.GenericGLService;
import com.elbar.cv_gen.service.GenericSpecificationService;

public interface TemplateRatingService extends GenericCUDService<TemplateRatingCreateDTO, TemplateRatingUpdateDTO, Integer>, GenericGLService<TemplateRatingGetDTO, TemplateRatingCriteria, Integer>, GenericSpecificationService<SearchCriteria, BetweenCriteria, TemplateRatingGetDTO> {
}
