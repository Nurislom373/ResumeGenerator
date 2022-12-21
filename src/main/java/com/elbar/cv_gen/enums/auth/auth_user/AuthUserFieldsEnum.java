package com.elbar.cv_gen.enums.auth.auth_user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AuthUserFieldsEnum {
    FIRST_NAME("firstName"),
    LAST_NAME("lastName"),
    PHONE("phone"),
    STATUS("status"),
    LANGUAGE("language"),
    ROLE("role");
    private final String value;
}
