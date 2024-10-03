package com.example.factory;

import com.example.model.Address;
import com.example.exceptions.CountryNotImplementedException;
import com.example.exceptions.TelephoneFormatException;
import com.example.model.AddressValidator;
import com.example.model.Telephone;

import java.util.LinkedHashMap;

public interface AbstractFactory {
	
	static  AbstractFactory getInstance(String country) throws CountryNotImplementedException {
		try {
			return Countries.valueOf(country.toUpperCase()).getFactory();
		} catch (IllegalArgumentException e) {
			throw new CountryNotImplementedException();
		}
	}

	Address createAddress(LinkedHashMap<String, String> address);

	AddressValidator createAddressValidator();

	Telephone createTelephone(String telephone) throws TelephoneFormatException;
	
}
