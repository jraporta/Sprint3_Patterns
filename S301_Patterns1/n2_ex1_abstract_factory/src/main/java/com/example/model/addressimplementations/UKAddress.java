package com.example.model.addressimplementations;

import com.example.model.Address;
import static com.example.model.addressimplementations.UKAddressValidator.Field;
import java.util.LinkedHashMap;

public class UKAddress implements Address {
	
	private static final String COUNTRY = "United Kingdom";
	private final LinkedHashMap<String, String> address;

	public UKAddress(LinkedHashMap<String, String> address){
		this.address = address;
	}


	@Override
	public String getField(String field) {
		return this.address.get(field) == null ? "" : this.address.get(field);
	}

	@Override
	public String getAddress() {
		return String.format("%s %s, %s%n%s%s  -  %s%n%s",
				this.getField(Field.NUMBER.name()), this.getField(Field.STREET.name()), this.getField(Field.APARTMENT.name()),
				this.getField(Field.NEIGHBOURHOOD_OR_DISTRICT.name()).isBlank() ? "" : this.getField(Field.NEIGHBOURHOOD_OR_DISTRICT.name()) + "\n",
				this.getField(Field.CITY.name()), this.getField(Field.POSTAL_CODE.name()),
				UKAddress.COUNTRY
				);
	}
	
	

}
