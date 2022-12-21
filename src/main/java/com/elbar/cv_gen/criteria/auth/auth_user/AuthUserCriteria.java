package com.elbar.cv_gen.criteria.auth.auth_user;

import com.elbar.cv_gen.criteria.GenericCriteria;
import com.elbar.cv_gen.enums.auth.auth_user.AuthUserFieldsEnum;
import lombok.Getter;
import lombok.Setter;
import org.springdoc.api.annotations.ParameterObject;

@Getter
@Setter
@ParameterObject
public class AuthUserCriteria extends GenericCriteria {
    private AuthUserFieldsEnum fieldsEnum;
}
