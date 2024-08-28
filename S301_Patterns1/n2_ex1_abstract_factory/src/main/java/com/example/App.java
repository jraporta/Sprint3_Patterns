package com.example;

import exeptions.NonExistantCountryException;
import util.Entrada;

public class App {
	
	static ContactBook contactBook = ContactBook.getInstance();
	
    public static void main(String[] args) {
    	
    	boolean quit = false;
    	do {
    		switch(menu()) {
    		   	case 1:
    		   		//to do
    		   		break;
    		   	case 2:
    		   		setTelephone();
    		   		break;
    		   	case 3:
    		   		//to do
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
    			+ "\n1. Add an address."
    			+ "\n2. Add a telephone number."
    			+ "\n3. Retrieve an address."
    			+ "\n4. Retrive a telephone number."
    			+ "\n5. About."
    			+ "\n0. Quit.\n");
    }
    
    public static void setTelephone() {
    	String name;
    	Telephone telephone;
    	AbstractFactory factory;
    	
    	name = Entrada.llegirString("Write the contact name: ");
   		try {
			factory = AbstractFactory.getInstance(Entrada.llegirString("Write the country: "));
		   	do {
		   		telephone = factory.createTelephone(Entrada.llegirString("Write the telephone number: "));
		   	} while (telephone == null);
		   	contactBook.setTelephone(name, telephone);
   		} catch (NonExistantCountryException e) {
   			System.out.println(e.getMessage());
		}
    }
    
    public static void retrieveTelephone() {
    	String name;
    	Telephone telephone;
    	
    	name = Entrada.llegirString("Write the contact name: ");
   		telephone = contactBook.getTelephone(name);
   		System.out.printf("%s -> %s%n", name, telephone);
    }
}
