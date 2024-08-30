package com.example;

import exeptions.TelephoneFormatException;

public class UKTelephone extends Telephone{
	
	private static final String REGEX = "^\\+440[1-3,7-9][0-9]{8,9}+$";
	private static final String COUNTRY = "United Kingdom";
	private static final String EXPLANATION = 
			"UK telephone starts with +44 followed by a 10 or 11 digits starting with 01, 02, 03, 07, 08 or 09.";

	public UKTelephone(String telephoneNumber) throws TelephoneFormatException {
		super(telephoneNumber);
	}

	@Override
	public String getCountry() {
		return UKTelephone.COUNTRY;
	}

	@Override
	protected String getRegex() {
		return UKTelephone.REGEX;
	}

	@Override
	protected String getFormatExplanation() {
		return UKTelephone.EXPLANATION;
	}

}
