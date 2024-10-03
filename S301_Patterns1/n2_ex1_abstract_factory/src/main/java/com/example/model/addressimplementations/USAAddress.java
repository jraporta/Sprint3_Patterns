package com.example.model.addressimplementations;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.example.exceptions.AddressAlreadyInitializedException;
import com.example.model.Address;

public class USAAddress implements Address{
	
	private static final String COUNTRY = "USA";
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
			return USAAddress.COUNTRY;
		default:
			return this.address.get(field) == null ? "" : this.address.get(field);
		}
	}

	
	@Override
	public List<String> getAddressValidator() {
		List<String> addressFields = new ArrayList<>();
		for (field f: field.values()) {
			addressFields.add(f.name());
		}
		return addressFields;
	}

	@Override
	public boolean fieldIsMandatory(String field) {
		return USAAddress.field.valueOf(field).isMandatory;
	}

	@Override
	public String getFieldRegex(String field) {
		return USAAddress.field.valueOf(field).regex;
	}

	@Override
	public String getAddress() {
		return String.format("%s %s, %s%n%s, %s %s%n%s",
				this.getField("NUMBER"), this.getField("STREET"), this.getField("APARTMENT"),
				this.getField("CITY"), this.getField("STATE"), this.getField("POSTAL_CODE"),
				USAAddress.COUNTRY
				);
	}
	
	

}
