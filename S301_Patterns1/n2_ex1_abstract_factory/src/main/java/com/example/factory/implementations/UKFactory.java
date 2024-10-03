package com.example.factory.implementations;

import com.example.model.Address;
import com.example.model.AddressValidator;
import com.example.model.addressimplementations.UKAddress;
import com.example.exceptions.TelephoneFormatException;
import com.example.factory.AbstractFactory;
import com.example.model.Telephone;
import com.example.model.addressimplementations.UKAddressValidator;
import com.example.model.telephoneimplementations.UKTelephone;

import java.util.LinkedHashMap;

public class UKFactory implements AbstractFactory {

	@Override
	public Address createAddress(LinkedHashMap<String, String> address) {
		return new UKAddress(address);
	}

	@Override
	public AddressValidator createAddressValidator() {
		return new UKAddressValidator();
	}

	@Override
	public Telephone createTelephone(String telephone) throws TelephoneFormatException {
		return new UKTelephone(telephone);
	}

}
