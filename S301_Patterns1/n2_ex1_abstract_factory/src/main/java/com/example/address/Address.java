package com.example.address;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Pattern;

import com.example.util.Entrada;

public abstract class Address {
	
	public abstract String getField(String field);
	
	public abstract List<String> getAddressFields();
	
	public abstract boolean fieldIsMandatory(String field);
	
	public abstract String getFieldRegex(String field);
	
	
	public LinkedHashMap<String, String> askForAddress() {
		LinkedHashMap<String, String> address = new LinkedHashMap<>();
		List<String> addressFields = getAddressFields();
		
		for (String field: addressFields) {
			boolean success = false;
			String regex = getFieldRegex(field);
				do {
				String value = Entrada.llegirString(String.format("Write the %s: ", field));
				value = value == "" ? null : value;
				if (fieldIsMandatory(field) && value == null) {
					System.out.printf("%s is a mandatory field.%n", field);
				}else if (fieldIsMandatory(field) && regex != null && !Pattern.matches(regex, value)){
					System.out.printf("Error of format, the %s has to have the format %s%n", field, regex);
				}else {
					address.put(field, value);
					success = true;
				}
			}while(!success);
		}
		return address;
	}
	
	public abstract String getAddress();
	
	
	
	
}

