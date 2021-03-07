package com.example.computerstorebackend.annotations;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DoubleValueValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DoubleValue {
    boolean isRequired();

    String message() default "Invalid double value";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
