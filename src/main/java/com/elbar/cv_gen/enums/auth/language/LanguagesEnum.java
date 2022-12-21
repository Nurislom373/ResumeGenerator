package com.elbar.cv_gen.enums.auth.language;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.webjars.NotFoundException;

import java.util.Arrays;
import java.util.Random;

@Getter
@RequiredArgsConstructor
public enum LanguagesEnum {
    EN("EN"),
    RU("RU"),
    UZ("UZ");
    private final String value;

    public static boolean hasLanguageIgnoreCase(String value) {
        return Arrays.stream(values())
                .anyMatch(f -> f.value.equalsIgnoreCase(value));
    }

    public static LanguagesEnum findAny() {
        return Arrays.asList(values())
                .get(new Random().nextInt(values().length));
    }

    public static LanguagesEnum getEqual(String var) {
        return Arrays.stream(values())
                .filter(f -> f.value.equals(var))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Language not found"));
    }
}
