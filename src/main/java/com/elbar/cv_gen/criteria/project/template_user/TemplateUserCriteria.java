package com.elbar.cv_gen.criteria.project.template_user;

import com.elbar.cv_gen.criteria.GenericCriteria;
import com.elbar.cv_gen.enums.project.templateUser.TemplateUserFieldsEnum;
import lombok.Getter;
import org.springdoc.api.annotations.ParameterObject;

@Getter
@ParameterObject
public class TemplateUserCriteria extends GenericCriteria {
    private TemplateUserFieldsEnum fieldsEnum;
}
