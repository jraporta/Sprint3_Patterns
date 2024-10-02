package com.example.telephone;

import java.util.regex.Pattern;

import com.example.exceptions.TelephoneFormatException;

public interface Telephone {

	Telephone create(String number)  throws TelephoneFormatException;

	String getNumber();
	
	String getCountry();
	
	String getValidationRegex();

	String getFormatErrorExplanation();

}
