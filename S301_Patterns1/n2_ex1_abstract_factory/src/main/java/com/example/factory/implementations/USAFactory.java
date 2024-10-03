package com.example.factory.implementations;

import com.example.model.Address;
import com.example.model.AddressValidator;
import com.example.model.addressimplementations.USAAddress;
import com.example.exceptions.TelephoneFormatException;
import com.example.factory.AbstractFactory;
import com.example.model.Telephone;
import com.example.model.addressimplementations.USAAddressValidator;
import com.example.model.telephoneimplementations.USATelephone;
import java.util.LinkedHashMap;

public class USAFactory implements AbstractFactory {

	@Override
	public Address createAddress(LinkedHashMap<String, String> address) {
		return new USAAddress(address);
	}

	@Override
	public AddressValidator createAddressValidator() {
		return new USAAddressValidator();
	}

	@Override
	public Telephone createTelephone(String telephone) throws TelephoneFormatException {
		return new USATelephone().initialize(telephone);
	}
	
}
