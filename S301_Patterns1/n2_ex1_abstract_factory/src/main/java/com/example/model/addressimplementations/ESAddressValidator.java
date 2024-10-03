package com.example.model.addressimplementations;

import com.example.model.AddressValidator;

import java.util.ArrayList;
import java.util.List;

public class ESAddressValidator implements AddressValidator {

    enum Field {
        STREET(true, null, null),
        //natural number
        NUMBER(true, "^\\d+$", "must be a natural number"),
        FLAT(false, null, null),
        APARTMENT(false, null, null),
        //5 digit number
        POSTAL_CODE(true, "^\\d{5}$", "must be a 5-digit number"),
        CITY(true, null, null),
        PROVINCE(true, null, null);

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
