package com.example.model.addressimplementations;

import com.example.exceptions.AddressAlreadyInitializedException;
import com.example.model.Address;
import com.example.model.AddressValidator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class UKAddress implements Address {
	
	private static final String COUNTRY = "United Kingdom";
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
			return UKAddress.COUNTRY;
		default:
			return this.address.get(field) == null ? "" : this.address.get(field);
		}
	}

	
	@Override
	public AddressValidator getAddressValidator() {
		return new UKAddressValidator();
	}

	@Override
	public String getAddress() {
		return String.format("%s %s, %s%n%s%s%n%s%n%s",
				this.getField("NUMBER"), this.getField("STREET"), this.getField("APARTMENT"),
				this.getField("NEIGHBOURHOOD_OR_DISTRICT").isBlank() ? "" : this.getField("NEIGHBOURHOOD_OR_DISTRICT") + "\n",
				this.getField("CITY"), this.getField("POSTAL_CODE"),
				UKAddress.COUNTRY
				);
	}
	
	

}
