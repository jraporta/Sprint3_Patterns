package com.example.model;

import com.example.exceptions.TelephoneFormatException;

public interface Telephone {

	Telephone initialize(String number)  throws TelephoneFormatException;

	String getNumber();
	
	String getCountry();

}
