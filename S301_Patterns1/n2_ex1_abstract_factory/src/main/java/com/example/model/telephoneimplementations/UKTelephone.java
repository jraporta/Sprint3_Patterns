package com.example.model.telephoneimplementations;

import com.example.exceptions.TelephoneAlreadyInitializedException;
import com.example.exceptions.TelephoneFormatException;
import com.example.model.Telephone;

public class UKTelephone implements Telephone {


	private static final String COUNTRY = "United Kingdom";
	private final String number;

	public UKTelephone (String number) throws TelephoneFormatException {
		this.number = number;
		new UKTelephoneValidator().validate(this);
	}

	@Override
	public String getNumber() {
		return this.number;
	}

}
