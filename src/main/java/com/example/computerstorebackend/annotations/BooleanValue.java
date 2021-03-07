package com.example.computerstorebackend.annotations;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = BooleanValueValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface BooleanValue {
    boolean isRequired();

    String message() default "Invalid boolean value";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}