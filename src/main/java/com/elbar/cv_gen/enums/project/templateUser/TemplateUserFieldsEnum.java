package com.elbar.cv_gen.enums.project.templateUser;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TemplateUserFieldsEnum {
    IS_EDIT("isEdit"),
    TEMPLATE_ID("templateId"),
    USER_ID("userId");
    private final String value;
}
