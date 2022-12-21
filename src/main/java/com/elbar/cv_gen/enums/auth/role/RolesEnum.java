package com.elbar.cv_gen.enums.auth.role;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.webjars.NotFoundException;

import java.util.Arrays;
import java.util.Random;

@Getter
@RequiredArgsConstructor
public enum RolesEnum {
    USER("USER"),
    ADMIN("ADMIN");
    private final String value;

    public static boolean hasRoleIgnoreCase(String value) {
        return Arrays.stream(values())
                .anyMatch(f -> f.value.equalsIgnoreCase(value));
    }

    public static RolesEnum getEqual(String var) {
        return Arrays.stream(values())
                .filter(f -> f.value.equals(var))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Role not found"));
    }

    public static RolesEnum findAny() {
        return Arrays.asList(values())
                .get(new Random().nextInt(values().length));
    }
}
