package com.example.computerstorebackend.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BooleanValueValidator implements ConstraintValidator<BooleanValue, Boolean> {
    private boolean isRequired;

    @Override
    public void initialize(BooleanValue constraintAnnotation) {
        isRequired = constraintAnnotation.isRequired();
    }

    @Override
    public boolean isValid(Boolean booleanValue, ConstraintValidatorContext constraintValidatorContext) {
        return isRequired ? booleanValue != null : booleanValue;
    }
}
