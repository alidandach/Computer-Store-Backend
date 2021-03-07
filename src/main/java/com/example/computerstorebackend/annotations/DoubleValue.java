package com.example.computerstorebackend.annotations;

import javax.validation.Constraint;
import java.lang.annotation.*;

/**
 * The interface Double value.
 */
@Documented
@Constraint(validatedBy = DoubleValueValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DoubleValue {
    /**
     * Is required boolean.
     *
     * @return the boolean
     */
    boolean isRequired();

    /**
     * Message string.
     *
     * @return the string
     */
    String message() default "Invalid double value";

    /**
     * Groups class [ ].
     *
     * @return the class [ ]
     */
    Class<?>[] groups() default {};

    /**
     * Payload class [ ].
     *
     * @return the class [ ]
     */
    Class<?>[] payload() default {};
}
