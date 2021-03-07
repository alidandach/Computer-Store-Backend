package com.example.computerstorebackend.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * The type Double value validator.
 */
public class DoubleValueValidator implements ConstraintValidator<DoubleValue, Double> {
    private boolean isRequired;

    @Override
    public void initialize(DoubleValue constraintAnnotation) {
        isRequired = constraintAnnotation.isRequired();
    }

    @Override
    public boolean isValid(Double value, ConstraintValidatorContext constraintValidatorContext) {
        return !isRequired || value != null;
    }
}
