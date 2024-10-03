package com.example.model.addressimplementations;

import com.example.model.AddressValidator;

import java.util.ArrayList;
import java.util.List;

public class UKAddressValidator implements AddressValidator {

    enum Field{
        //natural number
        NUMBER (true, "^\\d+$", "must be a natural number"),
        STREET (true, null, null),
        APARTMENT(false, null, null),
        NEIGHBOURHOOD_OR_DISTRICT (false, null, null),
        CITY (true, null, null),
        //5 to 7 character long string
        POSTAL_CODE (true, "^.{5,7}$",
                "must be 5 to 7 characters long and can include numbers an letters");

        private final boolean isMandatory;
        private final String regex;
        private final String explanation;

        Field(boolean b, String regex, String explanation) {
            this.isMandatory = b;
            this.regex = regex;
            this.explanation = explanation;
        }
    }

    @Override
    public List<String> getAddressFields() {
        List<String> addressFields = new ArrayList<>();
        for (Field field: Field.values()) {
            addressFields.add(field.name());
        }
        return addressFields;
    }

    @Override
    public boolean fieldIsMandatory(String field) {
        return Field.valueOf(field).isMandatory;
    }

    @Override
    public String getFieldRegex(String field) {
        return Field.valueOf(field).regex;
    }

    @Override
    public String getFormatErrorExplanation(String field) {
        return Field.valueOf(field).explanation;
    }

}
