package com.example;

import java.util.LinkedHashMap;
import java.util.regex.Pattern;

import util.Entrada;

public abstract class Address {
	
	private static final LinkedHashMap<String, String> ADDRESS_REGEX;
	private LinkedHashMap<String, String> address;
	
	static {
		ADDRESS_REGEX = new LinkedHashMap<>();
	}
	
	public abstract Address createAddress();
	
	public abstract String getCountry();
	
	public static LinkedHashMap<String, String> askForAddress() {
		LinkedHashMap<String, String> address = new LinkedHashMap<>();
		for (String key: ADDRESS_REGEX.keySet()) {
			boolean success = false;
			String regex = ADDRESS_REGEX.get(key);
				do {
				String value = Entrada.llegirString(String.format("Write the %s: ", key));
				if (regex != null && Pattern.matches(regex, value)) {
					address.put(key, value);
					success = true;
				} else if (regex == null && value == null) {
					success = true;
				} else {
					System.out.printf("Error of format, the %s has to have the format %s%n", key, regex);
				}
			}while(!success);
		}
		return address;
	}
	
	public String getAddress() {
		String response = "";
		for (String key: this.address.keySet()) {
			response += String.format("%s: %s", key, this.address.get(key));
		}
		return response;
	}
	
	
}

