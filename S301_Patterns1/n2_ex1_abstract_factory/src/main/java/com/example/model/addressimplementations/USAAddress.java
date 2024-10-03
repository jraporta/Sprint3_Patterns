package com.example.model.addressimplementations;

import java.util.LinkedHashMap;

import static com.example.model.addressimplementations.USAAddressValidator.Field;

import com.example.model.Address;

public class USAAddress implements Address{
	
	private static final String COUNTRY = "USA";
	private final LinkedHashMap<String, String> address;

	public USAAddress(LinkedHashMap<String, String> address){
		this.address = address;
	}

	@Override
	public String getField(String field) {
		return this.address.get(field) == null ? "" : this.address.get(field);
	}

	@Override
	public String getAddress() {
		return String.format("%s %s, %s%n%s, %s %s%n%s",
				this.getField(Field.NUMBER.name()), this.getField(Field.STREET.name()),
				this.getField(Field.APARTMENT.name()), this.getField(Field.CITY.name()),
				this.getField(Field.STATE.name()), this.getField(Field.POSTAL_CODE.name()),
				USAAddress.COUNTRY
				);
	}
	
	

}
