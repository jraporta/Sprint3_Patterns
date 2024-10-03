package com.example.model.telephoneimplementations;

import com.example.exceptions.TelephoneAlreadyInitializedException;
import com.example.exceptions.TelephoneFormatException;
import com.example.model.Telephone;

public class USATelephone implements Telephone {

	private static final String COUNTRY = "USA";

	private String number;

	@Override
	public Telephone initialize(String number) throws TelephoneFormatException {
		if (this.number != null){
			throw new TelephoneAlreadyInitializedException();
		}
		this.number = number;
		return new USATelephoneValidator().validate(this);
	}

	@Override
	public String getNumber() {
		return this.number;
	}

	@Override
	public String getCountry() {
		return USATelephone.COUNTRY;
	}

}