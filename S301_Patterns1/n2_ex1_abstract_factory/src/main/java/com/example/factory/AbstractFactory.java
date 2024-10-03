package com.example.factory;

import com.example.model.addressimplementations.Address;
import com.example.exceptions.NonExistantCountryException;
import com.example.exceptions.TelephoneFormatException;
import com.example.model.Telephone;
import com.example.model.Address;

import java.util.LinkedHashMap;

public interface AbstractFactory {
	
	public static  AbstractFactory getInstance(String country) throws NonExistantCountryException {
		try {
			return Countries.valueOf(country.toUpperCase()).getFactory();
		} catch (IllegalArgumentException e) {
			throw new NonExistantCountryException();
		}
	}

	public Address createAddress(LinkedHashMap<String, String> address);
	
	public Telephone createTelephone(String telephone) throws TelephoneFormatException;
	
}
