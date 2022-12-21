package com.elbar.cv_gen.enums.project.transaction;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TransactionFieldsEnum {
    AMOUNT("amount"),
    CARD_ID("cardId"),
    TEMPLATE_ID("templateId"),
    USER_ID("userId");
    private final String value;
}
