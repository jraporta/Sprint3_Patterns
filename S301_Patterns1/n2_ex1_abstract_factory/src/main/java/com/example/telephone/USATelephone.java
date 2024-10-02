package com.example.telephone;

import com.example.exceptions.TelephoneFormatException;

public class USATelephone implements Telephone{

	//Starts with +1 followed by a 10-digit number
	private static final String REGEX = "^\\+1[0-9]{10}$";
	private static final String COUNTRY = "USA";
	private static final String EXPLANATION = 
			"A com.example.telephone from the USA should be +1 followed by a 10-digit number.";
	private String number;

	@Override
	public Telephone create(String number) throws TelephoneFormatException {
		this.number = number;
		new TelephoneValidator().validate(this);
		return this;
	}

	@Override
	public String getNumber() {
		return this.number;
	}

	@Override
	public String getCountry() {
		return USATelephone.COUNTRY;
	}

	@Override
	public String getValidationRegex() {
		return USATelephone.REGEX;
	}

	@Override
	public String getFormatErrorExplanation() {
		return USATelephone.EXPLANATION;
	}

}
