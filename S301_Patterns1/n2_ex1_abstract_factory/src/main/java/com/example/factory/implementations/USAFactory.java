package com.example.factory.implementations;

import com.example.model.addressimplementations.Address;
import com.example.model.addressimplementations.USAAddress;
import com.example.exceptions.TelephoneFormatException;
import com.example.factory.AbstractFactory;
import com.example.model.Telephone;
import com.example.model.telephoneimplementations.USATelephone;

public class USAFactory implements AbstractFactory {

	@Override
	public Address createAddress() {
		return new USAAddress();
	}

	@Override
	public Telephone createTelephone(String telephone) throws TelephoneFormatException {
		return new USATelephone().initialize(telephone);
	}
	
}
