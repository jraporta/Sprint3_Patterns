package com.example.address;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class UKAddress extends Address{
	
	enum field{
		//natural number
		NUMBER (true, "^\\d+$"),
		STREET (true, null),
		APARTMENT(false, null),
		NEIGHBOURHOOD_OR_DISTRICT (false, null),
		CITY (true, null),
		//5 to 7 character long string
		POSTAL_CODE (true, "^.{5,7}$");

		private boolean isMandatory;
		private String regex;
		
		field(boolean b, String regex) {
			this.isMandatory = b;
			this.regex = regex;
		}
	}
	
	private static final String COUNTRY = "United Kingdom";
	private LinkedHashMap<String, String> address;
	
	public UKAddress() {
		this.address = super.askForAddress();
	}


	@Override
	public String getField(String field) {
		switch (field.toUpperCase()) {
		case "COUNTRY":
			return UKAddress.COUNTRY;
		default:
			return this.address.get(field) == null ? "" : this.address.get(field);
		}
	}

	
	@Override
	public List<String> getAddressFields() {
		List<String> addressFields = new ArrayList<>();
		for (field f: field.values()) {
			addressFields.add(f.name());
		}
		return addressFields;
	}

	@Override
	public boolean fieldIsMandatory(String field) {
		return UKAddress.field.valueOf(field).isMandatory;
	}

	@Override
	public String getFieldRegex(String field) {
		return UKAddress.field.valueOf(field).regex;
	}

	@Override
	public String getAddress() {
		return String.format("%s %s, %s%n%s%s%n%s%n%s",
				this.getField("NUMBER"), this.getField("STREET"), this.getField("APARTMENT"),
				this.getField("NEIGHBOURHOOD_OR_DISTRICT") == "" ? "" : this.getField("NEIGHBOURHOOD_OR_DISTRICT") + "\n",
				this.getField("CITY"), this.getField("POSTAL_CODE"),
				UKAddress.COUNTRY
				);
	}
	
	

}
