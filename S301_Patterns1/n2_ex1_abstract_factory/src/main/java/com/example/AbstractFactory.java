package com.example;

import com.example.address.Address;
import com.example.exceptions.NonExistantCountryException;
import com.example.exceptions.TelephoneFormatException;
import com.example.telephone.Telephone;

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
