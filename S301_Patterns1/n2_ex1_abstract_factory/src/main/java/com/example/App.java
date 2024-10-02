package com.example;

import com.example.address.Address;
import com.example.exceptions.NonExistantCountryException;
import com.example.exceptions.TelephoneFormatException;
import com.example.telephone.Telephone;
import com.example.util.Entrada;

public class App {
	
	static ContactBook contactBook = ContactBook.getInstance();
	
    public static void main(String[] args) {
    	
    	boolean quit = false;
    	do {
    		switch(menu()) {
    		   	case 1:
    		   		setAddress();
    		   		break;
    		   	case 2:
    		   		setTelephone();
    		   		break;
    		   	case 3:
    		   		retrieveAddress();
    		   		break;
    		   	case 4:
    		   		retrieveTelephone();
    		   		break;
    		   	case 5:
    		   		System.out.println(contactBook);
    		   		break;
    		   	case 0:
    		   		quit = true;
    		   		break;
    		   	default:
    		   		System.out.println("Select a valid option.");	
    		}
    	}while(!quit);
    }
    
    
    public static int menu() {
    	return Entrada.llegirInt("Select an option:"
    			+ "\n1. Add an com.example.address."
    			+ "\n2. Add a com.example.telephone number."
    			+ "\n3. Retrieve an com.example.address."
    			+ "\n4. Retrive a com.example.telephone number."
    			+ "\n5. About."
    			+ "\n0. Quit.\n");
    }
    
    	private static void setAddress() {
		String name;
    	Address address;
    	AbstractFactory factory;
    	
    	name = Entrada.llegirString("Write the contact name: ");
		try {
			factory = AbstractFactory.getInstance(Entrada.llegirString("Write the country: "));
			address = factory.createAddress();
			contactBook.setAddress(name, address);
		} catch (NonExistantCountryException e) {
			System.out.println(e.getMessage());
		}
	}
    
    public static void setTelephone() {
    	String name;
    	Telephone telephone;
    	AbstractFactory factory;
    	
    	name = Entrada.llegirString("Write the contact name: ");
   		try {
			factory = AbstractFactory.getInstance(Entrada.llegirString("Write the country: "));
		   	do {
		   		try {
					telephone = factory.createTelephone(Entrada.llegirString("Write the com.example.telephone number: "));
				} catch (TelephoneFormatException e) {
					System.out.println(e.getMessage());
					telephone = null;
				}
		   	} while (telephone == null);
		   	contactBook.setTelephone(name, telephone);
   		} catch (NonExistantCountryException e) {
   			System.out.println(e.getMessage());
		}
    }
    
    private static void retrieveAddress() {
    	String name;
    	Address address;
    	
    	name = Entrada.llegirString("Write the contact name: ");
   		address = contactBook.getAddress(name);
   		System.out.print(address != null ? String.format("%s -> %n%s%n", name, address.getAddress()) :
   			String.format("No entry found for: %s.%n", name));
	}
    
    public static void retrieveTelephone() {
    	String name;
    	Telephone telephone;
    	
    	name = Entrada.llegirString("Write the contact name: ");
   		telephone = contactBook.getTelephone(name);
   		System.out.print(telephone != null ? String.format("%s -> %s%n", name, telephone) :
   			String.format("No entry found for: %s.%n", name));
    }
}
