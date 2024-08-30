package com.example;

import exeptions.TelephoneFormatException;

public class USAFactory implements AbstractFactory{

	@Override
	public Address createAddress() {
		return null;
	}

	@Override
	public Telephone createTelephone(String telephone) throws TelephoneFormatException {
		return new USATelephone(telephone);
	}
	
}
