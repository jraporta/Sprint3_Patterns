package com.example.model.telephoneimplementations;

import com.example.exceptions.TelephoneFormatException;
import com.example.model.Telephone;

public class ESTelephone implements Telephone {

	private static final String COUNTRY = "Spain";

	private final String number;

	public ESTelephone (String number) throws TelephoneFormatException {
		this.number = number;
		new ESTelephoneValidator().validate(this);
	}

	@Override
	public String getNumber() {
		return this.number;
	}

}
