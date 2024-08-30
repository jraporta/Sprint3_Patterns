package com.example;

import exeptions.TelephoneFormatException;

public class ESFactory implements AbstractFactory{

	@Override
	public Address createAddress() {
		return null;
	}

	@Override
	public Telephone createTelephone(String telephone) throws TelephoneFormatException {
		return new ESTelephone(telephone);
	}

}
