package com.example.model.telephoneimplementations;

import com.example.model.TelephoneValidator;

public class UKTelephoneValidator implements TelephoneValidator {

    //Starts with +440 followed by a 9 or 8-digit number that begins with a digit from 1 to 3 or 7 to 9
    private static final String REGEX = "^\\+440[1-3,7-9][0-9]{8,9}$";

    private static final String EXPLANATION =
            "UK telephone start with +44 followed by a 10 or 11 digits starting with 01, 02, 03, 07, 08 or 09.";

    @Override
    public String getValidationRegex() {
        return UKTelephoneValidator.REGEX;
    }

    @Override
    public String getFormatErrorExplanation() {
        return UKTelephoneValidator.EXPLANATION;
    }

}
