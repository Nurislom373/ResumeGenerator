package com.elbar.cv_gen.enums.auth.status;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.webjars.NotFoundException;

import java.util.Arrays;
import java.util.Random;

@Getter
@RequiredArgsConstructor
public enum StatusEnum {
    ACTIVE("ACTIVE"),
    NO_ACTIVE("NO_ACTIVE"),
    BLOCK("BLOCK");
    private final String value;

    public static boolean hasStatusIgnoreCase(String value) {
        return Arrays.stream(values())
                .anyMatch(f -> f.value.equalsIgnoreCase(value));
    }

    public static StatusEnum findAny() {
        return Arrays.asList(values())
                .get(new Random().nextInt(values().length));
    }

    public static StatusEnum getEqual(String var) {
        return Arrays.stream(values())
                .filter(f -> f.value.equals(var))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Status not found"));
    }
}

