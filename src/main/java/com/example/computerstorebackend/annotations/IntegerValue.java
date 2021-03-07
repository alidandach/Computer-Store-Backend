package com.example.computerstorebackend.annotations;

import javax.validation.Constraint;
import java.lang.annotation.*;

/**
 * The interface Integer value.
 */
@Documented
@Constraint(validatedBy = IntegerValueValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IntegerValue {
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
    String message() default "Invalid integer value";

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
