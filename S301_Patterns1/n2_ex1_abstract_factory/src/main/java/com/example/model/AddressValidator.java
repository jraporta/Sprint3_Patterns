package com.example.model;

import java.util.List;

public interface AddressValidator {

    public List<String> getAddressFields();

    public boolean fieldIsMandatory(String field);

    public String getFieldRegex(String field);

    String getFormatErrorExplanation(String field);

}
