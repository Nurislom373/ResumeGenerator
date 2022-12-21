package com.elbar.cv_gen.service.project.category;

import com.elbar.cv_gen.criteria.BetweenCriteria;
import com.elbar.cv_gen.criteria.SearchCriteria;
import com.elbar.cv_gen.criteria.project.category.CategoryCriteria;
import com.elbar.cv_gen.dto.project.category.CategoryCreateDTO;
import com.elbar.cv_gen.dto.project.category.CategoryGetDTO;
import com.elbar.cv_gen.dto.project.category.CategoryUpdateDTO;
import com.elbar.cv_gen.service.GenericCUDService;
import com.elbar.cv_gen.service.GenericGLService;
import com.elbar.cv_gen.service.GenericSpecificationService;

public interface CategoryService extends GenericCUDService<CategoryCreateDTO, CategoryUpdateDTO, Integer>, GenericGLService<CategoryGetDTO, CategoryCriteria, Integer>, GenericSpecificationService<SearchCriteria, BetweenCriteria, CategoryGetDTO> {

    String getCategoryTitle(Integer id);

}
