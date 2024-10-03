package com.example.factory.implementations;

import com.example.model.Address;
import com.example.model.AddressValidator;
import com.example.model.addressimplementations.ESAddress;
import com.example.exceptions.TelephoneFormatException;
import com.example.factory.AbstractFactory;
import com.example.model.addressimplementations.ESAddressValidator;
import com.example.model.telephoneimplementations.ESTelephone;
import com.example.model.Telephone;

import java.util.LinkedHashMap;

public class ESFactory implements AbstractFactory {

	@Override
	public Address createAddress(LinkedHashMap<String, String> address) {
		return new ESAddress(address);
	}

	@Override
	public AddressValidator createAddressValidator() {
		return new ESAddressValidator();
	}

	@Override
	public Telephone createTelephone(String telephone) throws TelephoneFormatException {
		return new ESTelephone(telephone);
	}

}
