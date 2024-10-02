package com.example.factory;

import com.example.AbstractFactory;

import com.example.address.Address;
import com.example.address.ESAddress;
import com.example.exceptions.TelephoneFormatException;
import com.example.telephone.ESTelephone;
import com.example.telephone.Telephone;

public class ESFactory implements AbstractFactory{

	@Override
	public Address createAddress() {
		return new ESAddress();
	}

	@Override
	public Telephone createTelephone(String telephone) throws TelephoneFormatException {
		return new ESTelephone().create(telephone);
	}

}
