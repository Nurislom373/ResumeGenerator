package com.elbar.cv_gen.criteria.project.category;

import com.elbar.cv_gen.criteria.GenericCriteria;
import com.elbar.cv_gen.enums.project.category.CategoryPropertiesEnum;
import lombok.Getter;
import lombok.Setter;
import org.springdoc.api.annotations.ParameterObject;

@Getter
@Setter
@ParameterObject
public class CategoryCriteria extends GenericCriteria {
    private CategoryPropertiesEnum properties;
}
