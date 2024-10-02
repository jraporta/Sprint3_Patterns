package com.example;

import java.util.HashMap;
import java.util.Map;

import com.example.address.Address;
import com.example.telephone.Telephone;

public class ContactBook {
	
	private static ContactBook instance = null;
	
	private Map<String, Address> addressBook;
	private Map<String, Telephone> telephoneBook;
	
	
	private ContactBook() {
		this.addressBook = new HashMap<>();
		this.telephoneBook = new HashMap<>();
	}
	
	public static ContactBook getInstance() {
		if (ContactBook.instance == null) {
			instance = new ContactBook();
		}
		return instance;
	}

	public Address getAddress(String name) {
		return this.addressBook.get(name);
	}

	public Telephone getTelephone(String name) {
		return this.telephoneBook.get(name);
	}

	public void setAddress(String name, Address adress) {
		this.addressBook.put(name, adress);
	}

	public void setTelephone(String name, Telephone telephone) {
		this.telephoneBook.put(name, telephone);
	}

	@Override
	public String toString() {
		return String.format("ContactBook containing %d addresses and %d telephones.",
				this.addressBook.size(), this.telephoneBook.size());
	}
	
	

}
