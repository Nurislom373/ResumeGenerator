package com.elbar.cv_gen.enums.auth.auth_token;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AuthTokenFieldsEnum {
    TYPE("type"),
    DURATION("duration");
    private final String value;
}
