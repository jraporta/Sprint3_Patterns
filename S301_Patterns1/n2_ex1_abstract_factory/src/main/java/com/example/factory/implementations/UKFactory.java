package com.example.factory.implementations;

import com.example.model.addressimplementations.Address;
import com.example.model.addressimplementations.UKAddress;
import com.example.exceptions.TelephoneFormatException;
import com.example.factory.AbstractFactory;
import com.example.model.Telephone;
import com.example.model.telephoneimplementations.UKTelephone;

public class UKFactory implements AbstractFactory {

	@Override
	public Address createAddress() {
		return new UKAddress();
	}

	@Override
	public Telephone createTelephone(String telephone) throws TelephoneFormatException {
		return new UKTelephone().initialize(telephone);
	}

}
