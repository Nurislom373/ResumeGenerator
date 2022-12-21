package com.elbar.cv_gen.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IdConstraintValidator.class)
@Documented
public @interface IdConstraint {

    String message() default "Invalid.Id";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
