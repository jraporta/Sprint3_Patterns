package address;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class USAAddress extends Address{
	
	enum field{
		NUMBER (true, "^\\d+$"),
		STREET (true, null),
		APPARTMENT (false, null),
		CITY (true, null),
		STATE (true, "^\\D{2}$"),
		POSTAL_CODE (true, "^\\d{5}(-\\d{4})?$");

		private boolean isMandatory;
		private String regex;
		
		field(boolean b, String regex) {
			this.isMandatory = b;
			this.regex = regex;
		}
	}
	
	private static final String COUNTRY = "USA";
	private LinkedHashMap<String, String> address;
	
	public USAAddress() {
		this.address = super.askForAddress();
	}


	@Override
	public String getField(String field) {
		switch (field.toUpperCase()) {
		case "COUNTRY":
			return USAAddress.COUNTRY;
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
		return USAAddress.field.valueOf(field).isMandatory;
	}

	@Override
	public String getFieldRegex(String field) {
		return USAAddress.field.valueOf(field).regex;
	}

	@Override
	public String getAddress() {
		return String.format("%s %s, %s%n%s, %s %s%n%s",
				this.getField("NUMBER"), this.getField("STREET"), this.getField("APPARTMENT"),
				this.getField("CITY"), this.getField("STATE"), this.getField("POSTAL_CODE"),
				USAAddress.COUNTRY
				);
	}
	
	

}
