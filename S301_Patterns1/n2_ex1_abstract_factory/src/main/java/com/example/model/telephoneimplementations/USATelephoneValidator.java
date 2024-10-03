package com.example.model.telephoneimplementations;

import com.example.model.TelephoneValidator;

public class USATelephoneValidator implements TelephoneValidator {

    //Starts with +1 followed by a 10-digit number
    private static final String REGEX = "^\\+1[0-9]{10}$";

    private static final String EXPLANATION =
            "A com.example.model.telephone from the USA should be +1 followed by a 10-digit number.";

    @Override
    public String getValidationRegex() {
        return USATelephoneValidator.REGEX;
    }

    @Override
    public String getFormatErrorExplanation() {
        return USATelephoneValidator.EXPLANATION;
    }

}
