package com.example;

import address.Address;
import exeptions.NonExistantCountryException;
import exeptions.TelephoneFormatException;
import telephone.Telephone;

public interface AbstractFactory {
	
	public static  AbstractFactory getInstance(String country) throws NonExistantCountryException {
		try {
			return Countries.valueOf(country.toUpperCase()).getFactory();
		} catch (IllegalArgumentException e) {
			throw new NonExistantCountryException();
		}
	}

	public Address createAddress();
	
	public Telephone createTelephone(String telephone) throws TelephoneFormatException;
	
}
