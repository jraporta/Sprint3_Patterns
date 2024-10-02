package com.example.telephone;

import com.example.exceptions.TelephoneFormatException;

import java.util.regex.Pattern;

public class TelephoneValidator {

    protected String validate(Telephone telephone) throws TelephoneFormatException {
        if (telephone.getValidationRegex() == null || Pattern.matches(telephone.getValidationRegex(), telephone.getNumber())) {
            return telephone.getNumber();
        } else {
            throw new TelephoneFormatException(telephone.getFormatErrorExplanation());
        }
    }

}
