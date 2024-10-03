package com.example.model.telephoneimplementations;

import com.example.exceptions.TelephoneAlreadyInitializedException;
import com.example.exceptions.TelephoneFormatException;
import com.example.model.Telephone;

public class USATelephone implements Telephone {

	private static final String COUNTRY = "USA";

	private final String number;

	public USATelephone (String number) throws TelephoneFormatException {
		this.number = number;
		new USATelephoneValidator().validate(this);
	}

	@Override
	public String getNumber() {
		return this.number;
	}

}
