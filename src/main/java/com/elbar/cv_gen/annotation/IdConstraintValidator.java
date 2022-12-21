package com.elbar.cv_gen.annotation;

import com.elbar.cv_gen.exception.exception.InvalidValidationException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class IdConstraintValidator implements ConstraintValidator<IdConstraint, Integer> {

    private String message;

    @Override
    public void initialize(IdConstraint constraintAnnotation) {
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (Objects.isNull(value) || value < 1) {
            if (message.equals("Invalid.Id")){
                throw new InvalidValidationException("Invalid ID");
            } else {
                throw new InvalidValidationException(message);
            }
        }
        return true;
    }

}
