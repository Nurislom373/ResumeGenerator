package com.elbar.cv_gen.controller.project.category;

import com.elbar.cv_gen.controller.GenericCUDController;
import com.elbar.cv_gen.controller.GenericGLController;
import com.elbar.cv_gen.controller.GenericSpecificationController;
import com.elbar.cv_gen.criteria.BetweenCriteria;
import com.elbar.cv_gen.criteria.SearchCriteria;
import com.elbar.cv_gen.criteria.project.category.CategoryCriteria;
import com.elbar.cv_gen.dto.project.category.CategoryCreateDTO;
import com.elbar.cv_gen.dto.project.category.CategoryGetDTO;
import com.elbar.cv_gen.dto.project.category.CategoryUpdateDTO;

public interface CategoryController extends GenericCUDController<CategoryCreateDTO, CategoryUpdateDTO, Integer>, GenericGLController<CategoryGetDTO, CategoryCriteria, Integer>, GenericSpecificationController<SearchCriteria, BetweenCriteria, CategoryGetDTO> {
}
