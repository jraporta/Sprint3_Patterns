package com.example;

import java.util.regex.Pattern;

import exeptions.TelephoneFormatException;

public abstract class Telephone {
	
	private String telephoneNumber;
	
	public Telephone(String telephoneNumber) throws TelephoneFormatException {
		this.telephoneNumber = validate(telephoneNumber);
	}
	
	protected String validate(String telephoneNumber) throws TelephoneFormatException{
		if (getRegex() == null || Pattern.matches(getRegex(), telephoneNumber)) {
			return telephoneNumber;
		} else {
			throw new TelephoneFormatException(getFormatExplanation());
		}
	}
	
	public abstract String getCountry();
	
	protected abstract String getRegex();

	protected abstract String getFormatExplanation();
	
	@Override
	public String toString() {
		return this.telephoneNumber;
	}
	
	
}
