package com.example.model.addressimplementations;

import com.example.model.AddressValidator;

import java.util.ArrayList;
import java.util.List;

public class USAAddressValidator implements AddressValidator {

    enum Field{
        STREET (true, null, null),
        //natural number
        NUMBER (true, "^\\d+$", "must be a natural number"),
        APARTMENT(false, null, null),
        CITY (true, null, null),
        //Two non-digit characters
        STATE (true, "^\\D{2}$", "must be 2 non-digit character long chain"),
        //5-digit number optionally followed by a dash plus a 4-digit number
        POSTAL_CODE (true, "^\\d{5}(-\\d{4})?$",
                "must be a 5-digit number followed optionally by a dash and a 4 digit number");

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
