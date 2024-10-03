package com.example.model;

import java.util.List;

public interface AddressValidator {

    List<String> getAddressFields();

    boolean fieldIsMandatory(String field);

    String getFieldRegex(String field);

    String getFormatErrorExplanation(String field);

}
