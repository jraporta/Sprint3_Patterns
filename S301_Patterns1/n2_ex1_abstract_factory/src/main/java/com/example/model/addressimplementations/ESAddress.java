package com.example.model.addressimplementations;

import com.example.exceptions.AddressAlreadyInitializedException;
import com.example.exceptions.TelephoneAlreadyInitializedException;
import com.example.model.Address;
import com.example.model.AddressValidator;

import java.util.LinkedHashMap;

public class ESAddress implements Address {
	
	private static final String COUNTRY = "Spain";
	private LinkedHashMap<String, String> address;

	@Override
	public Address initialize(LinkedHashMap<String, String> address) {
		if (this.address != null){
			throw new AddressAlreadyInitializedException();
		}
		this.address = address;
		return this;
	}

	@Override
	public String getField(String field) {
		switch (field.toUpperCase()) {
		case "COUNTRY":
			return ESAddress.COUNTRY;
		default:
			return this.address.get(field) == null ? "" : this.address.get(field);
		}
	}

	@Override
	public AddressValidator getAddressValidator() {
		return new ESAddressValidator();
	}

	@Override
	public String getAddress() {
		return String.format("%s %s, %s %s%n%s - %s%n%s",
				this.getField("STREET"), this.getField("NUMBER"),
				this.getField("FLAT"), this.getField("APARTMENT"),
				this.getField("POSTAL_CODE"), this.getField("CITY"),
				ESAddress.COUNTRY
				);
	}
	
	

}
