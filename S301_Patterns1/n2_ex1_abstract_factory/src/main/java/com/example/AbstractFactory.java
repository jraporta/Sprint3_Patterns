package com.example;

import exeptions.NonExistantCountryException;

public interface AbstractFactory {
	
	public static  AbstractFactory getInstance(String country) throws NonExistantCountryException {
		try {
			return Countries.valueOf(country.toUpperCase()).getFactory();
		} catch (IllegalArgumentException e) {
			throw new NonExistantCountryException();
		}
	}

	public Address createAddress();
	
	public Telephone createTelephone(String telephone);
	
}
