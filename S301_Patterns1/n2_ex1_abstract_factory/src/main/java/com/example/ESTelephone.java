package com.example;

import exeptions.TelephoneFormatException;

public class ESTelephone extends Telephone{
	
	private static final String REGEX = "\\+34[0-9]{9}+";
	private static final String COUNTRY = "Spain";
	private static final String EXPLANATION = "Spanish telephone should be +34 followed by a 9-digit number.";

	public ESTelephone(String telephoneNumber) throws TelephoneFormatException {
		super(telephoneNumber);
	}

	@Override
	public String getCountry() {
		return ESTelephone.COUNTRY;
	}

	@Override
	protected String getRegex() {
		return ESTelephone.REGEX;
	}

	@Override
	protected String getFormatExplanation() {
		return ESTelephone.EXPLANATION;
	}

}
