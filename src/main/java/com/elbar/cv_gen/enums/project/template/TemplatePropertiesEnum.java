package com.elbar.cv_gen.enums.project.template;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TemplatePropertiesEnum {
    TITLE("title");
    private final String value;
}
