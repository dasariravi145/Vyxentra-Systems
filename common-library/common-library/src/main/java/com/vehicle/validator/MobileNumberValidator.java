package com.vehicle.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;


public class MobileNumberValidator implements ConstraintValidator<ValidMobileNumber,String> {

    private static final Pattern MOBILE_PATTERN = Pattern.compile("^[0-9]{10}$");

    @Override
    public boolean isValid(String mobileNumber, ConstraintValidatorContext context) {
        if (mobileNumber == null) {
            return false;
        }
        return MOBILE_PATTERN.matcher(mobileNumber).matches();
    }
}
