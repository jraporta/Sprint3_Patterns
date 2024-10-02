package com.example.factory;

import com.example.AbstractFactory;

import com.example.address.Address;
import com.example.address.UKAddress;
import com.example.exceptions.TelephoneFormatException;
import com.example.telephone.Telephone;
import com.example.telephone.UKTelephone;

public class UKFactory implements AbstractFactory{

	@Override
	public Address createAddress() {
		return new UKAddress();
	}

	@Override
	public Telephone createTelephone(String telephone) throws TelephoneFormatException {
		return new UKTelephone(telephone);
	}

}
