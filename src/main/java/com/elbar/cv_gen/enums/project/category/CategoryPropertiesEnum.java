package com.elbar.cv_gen.enums.project.category;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CategoryPropertiesEnum {
    TITLE("title"), DESCRIPTION("description");
    private final String value;
}
