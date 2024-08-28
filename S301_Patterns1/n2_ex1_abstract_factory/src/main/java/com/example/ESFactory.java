package com.example;

import exeptions.TelephoneFormatException;

public class ESFactory implements AbstractFactory{
	
	private static AbstractFactory instance = null;
	
	public static AbstractFactory getInstance() {
		if (ESFactory.instance == null) {
			instance = new ESFactory();
		}
		return instance;
	}

	@Override
	public Address createAddress() {
		return null;
	}

	@Override
	public Telephone createTelephone(String telephone) {
		Telephone checkedTelephone;
		try {
			checkedTelephone = new ESTelephone(telephone);
		} catch (TelephoneFormatException e) {
			System.out.println(e.getMessage());
			checkedTelephone = null;
		}
		return checkedTelephone;
	}

}
