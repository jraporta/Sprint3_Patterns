package com.example.telephone;

import com.example.exceptions.TelephoneFormatException;

public class UKTelephone implements Telephone{

	//Starts with +440 followed by a 9 or 8-digit number that begins with a digit from 1 to 3 or 7 to 9
	private static final String REGEX = "^\\+440[1-3,7-9][0-9]{8,9}$";
	private static final String COUNTRY = "United Kingdom";
	private static final String EXPLANATION = 
			"UK com.example.telephone starts with +44 followed by a 10 or 11 digits starting with 01, 02, 03, 07, 08 or 09.";
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
		return UKTelephone.COUNTRY;
	}

	@Override
	public String getValidationRegex() {
		return UKTelephone.REGEX;
	}

	@Override
	public String getFormatErrorExplanation() {
		return UKTelephone.EXPLANATION;
	}

}
