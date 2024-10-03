package com.example.model;

import com.example.exceptions.TelephoneFormatException;

import java.util.regex.Pattern;

public interface TelephoneValidator {

     default Telephone validate(Telephone telephone) throws TelephoneFormatException {
        if (this.getValidationRegex() == null || Pattern.matches(this.getValidationRegex(), telephone.getNumber())) {
            return telephone;
        } else {
            throw new TelephoneFormatException(this.getFormatErrorExplanation());
        }
    }

    String getValidationRegex();

    String getFormatErrorExplanation();

}
