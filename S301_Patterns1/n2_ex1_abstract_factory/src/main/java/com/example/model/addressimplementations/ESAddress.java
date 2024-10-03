package com.example.model.addressimplementations;
import com.example.model.Address;
import static com.example.model.addressimplementations.ESAddressValidator.Field;

import java.util.LinkedHashMap;

public class ESAddress implements Address {
	
	private static final String COUNTRY = "Spain";
	private final LinkedHashMap<String, String> address;

	public ESAddress(LinkedHashMap<String, String> address){
		this.address = address;
	}

	@Override
	public String getField(String field) {
		return this.address.get(field) == null ? "" : this.address.get(field);
	}

	@Override
	public String getAddress() {
		return String.format("%s %s, %s %s%n%s - %s%n%s (%s)",
				this.getField(Field.STREET.name()), this.getField(Field.NUMBER.name()),
				this.getField(Field.FLOOR.name()), this.getField(Field.APARTMENT.name()),
				this.getField(Field.POSTAL_CODE.name()), this.getField(Field.CITY.name()),
				this.getField(Field.PROVINCE.name()), ESAddress.COUNTRY
				);
	}

}
