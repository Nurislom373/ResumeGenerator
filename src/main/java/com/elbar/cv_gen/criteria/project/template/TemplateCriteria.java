package com.elbar.cv_gen.criteria.project.template;

import com.elbar.cv_gen.criteria.GenericCriteria;
import com.elbar.cv_gen.enums.project.template.TemplatePropertiesEnum;
import lombok.Getter;
import lombok.Setter;
import org.springdoc.api.annotations.ParameterObject;

@Getter
@Setter
@ParameterObject
public class TemplateCriteria extends GenericCriteria {
    private TemplatePropertiesEnum properties;
}
