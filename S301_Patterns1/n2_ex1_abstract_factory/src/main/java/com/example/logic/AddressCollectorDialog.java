package com.example.logic;

import com.example.model.AddressValidator;
import com.example.util.Entrada;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Pattern;

public class AddressCollectorDialog {

    public static LinkedHashMap<String, String> askForAddress(AddressValidator validator) {
        LinkedHashMap<String, String> addressMap = new LinkedHashMap<>();

        List<String> addressFields = validator.getAddressFields();

        for (String field: addressFields) {
            boolean success = false;
            String regex = validator.getFieldRegex(field);
            do {
                String value = Entrada.llegirString(String.format("Write the %s: ", field));
                value = value.isBlank() ? null : value;
                if (validator.fieldIsMandatory(field) && value == null) {
                    System.out.printf("%s is a mandatory field.%n", field);
                }else if (validator.fieldIsMandatory(field) && regex != null && !Pattern.matches(regex, value)){
                    System.out.printf("Error of format, the %s has to have the format %s%n",
                            field, validator.getFormatErrorExplanation(field));
                }else {
                    addressMap.put(field, value);
                    success = true;
                }
            }while(!success);
        }
        return addressMap;
    }


}
