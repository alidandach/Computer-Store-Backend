package com.example.computerstorebackend.annotations;

import javax.validation.Constraint;
import java.lang.annotation.*;

/**
 * The interface String value.
 */
@Documented
@Constraint(validatedBy = StringValueValidator.class)
@Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface StringValue {
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
    String message() default "Invalid string value";

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
