package com.example.telephone;

import com.example.exceptions.TelephoneFormatException;

public class ESTelephone implements Telephone{

	//Starts with +34 followed by a 9-digit number that begins with a digit from 6 to 9
	private static final String REGEX = "^\\+34[6-9][0-9]{8}$";
	private static final String COUNTRY = "Spain";
	private static final String EXPLANATION = 
			"Spanish com.example.telephone should be +34 followed by a 9-digit number starting with 9,8, 7 or 6.";
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
		return ESTelephone.COUNTRY;
	}

	@Override
	public String getValidationRegex() {
		return ESTelephone.REGEX;
	}

	@Override
	public String getFormatErrorExplanation() {
		return ESTelephone.EXPLANATION;
	}

}
