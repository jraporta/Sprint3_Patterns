package com.example.model;

import com.example.exceptions.AddressBookDuplicateKeyException;
import com.example.exceptions.TelephoneBookDuplicateKeyException;

import java.util.HashMap;
import java.util.Map;

public class ContactBook {
	
	private static ContactBook instance = null;
	
	private final Map<String, Address> addressBook;
	private final Map<String, Telephone> telephoneBook;
	
	
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

	public void setAddress(String name, Address address) {
		this.addressBook.put(name, address);
	}

	public void setTelephone(String name, Telephone telephone) {
		this.telephoneBook.put(name, telephone);
	}

	public void addressBookCheckNameIsAvailable(String name) throws AddressBookDuplicateKeyException {
		if (this.addressBook.containsKey(name)){
			throw new AddressBookDuplicateKeyException(String.format("There is already an entry for %s.", name));
		}
	}

	public void telephoneBookCheckNameIsAvailable(String name) throws TelephoneBookDuplicateKeyException {
		if (this.telephoneBook.containsKey(name)){
			throw new TelephoneBookDuplicateKeyException(String.format("There is already an entry for %s.", name));
		}
	}

	@Override
	public String toString() {
		return String.format("Your contact book contains %d addresses and %d telephones.",
				this.addressBook.size(), this.telephoneBook.size());
	}



}
