package com.example.model.telephoneimplementations;

import com.example.model.TelephoneValidator;

public class ESTelephoneValidator implements TelephoneValidator {

    //Starts with +34 followed by a 9-digit number that begins with a digit from 6 to 9
    private static final String REGEX = "^\\+34[6-9][0-9]{8}$";

    private static final String EXPLANATION =
            "Spanish telephones should be +34 followed by a 9-digit number starting with 9,8, 7 or 6.";

    @Override
    public String getValidationRegex() {
        return ESTelephoneValidator.REGEX;
    }

    @Override
    public String getFormatErrorExplanation() {
        return ESTelephoneValidator.EXPLANATION;
    }

}
