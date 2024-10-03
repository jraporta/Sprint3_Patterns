package com.example.model;

import java.util.LinkedHashMap;

public interface Address {

	Address initialize(LinkedHashMap<String, String> address);
	
	public String getField(String field);
	
	public AddressValidator getAddressValidator();
	
	public String getAddress();

}

