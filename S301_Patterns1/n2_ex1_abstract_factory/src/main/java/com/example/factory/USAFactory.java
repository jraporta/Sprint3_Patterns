package com.example.factory;

import com.example.AbstractFactory;

import com.example.address.Address;
import com.example.address.USAAddress;
import com.example.exceptions.TelephoneFormatException;
import com.example.telephone.Telephone;
import com.example.telephone.USATelephone;

public class USAFactory implements AbstractFactory{

	@Override
	public Address createAddress() {
		return new USAAddress();
	}

	@Override
	public Telephone createTelephone(String telephone) throws TelephoneFormatException {
		return new USATelephone().create(telephone);
	}
	
}
