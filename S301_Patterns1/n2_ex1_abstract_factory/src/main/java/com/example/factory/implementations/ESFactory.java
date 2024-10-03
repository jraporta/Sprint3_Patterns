package com.example.factory.implementations;

import com.example.model.addressimplementations.Address;
import com.example.model.addressimplementations.ESAddress;
import com.example.exceptions.TelephoneFormatException;
import com.example.factory.AbstractFactory;
import com.example.model.telephoneimplementations.ESTelephone;
import com.example.model.Telephone;

import java.util.LinkedHashMap;

public class ESFactory implements AbstractFactory {

	@Override
	public Address createAddress(LinkedHashMap<String, String> address) {
		return new ESAddress(address);
	}

	@Override
	public Telephone createTelephone(String telephone) throws TelephoneFormatException {
		return new ESTelephone().initialize(telephone);
	}

}
