package com.example;

import exeptions.TelephoneFormatException;

public class UKFactory implements AbstractFactory{

	@Override
	public Address createAddress() {
		return null;
	}

	@Override
	public Telephone createTelephone(String telephone) throws TelephoneFormatException {
		return new UKTelephone(telephone);
	}

}
