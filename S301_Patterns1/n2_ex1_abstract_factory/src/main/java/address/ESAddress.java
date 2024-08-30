package address;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ESAddress extends Address{
	
	enum field{
		STREET (true, null),
		NUMBER (true, "^\\d+$"),
		FLAT (false, null),
		APPARTMENT (false, null),
		POSTAL_CODE (true, "^\\d{5}$"),
		CITY (true, null),
		PROVINCE (true, null);

		private boolean isMandatory;
		private String regex;
		
		field(boolean b, String regex) {
			this.isMandatory = b;
			this.regex = regex;
		}
	}
	
	private static final String COUNTRY = "Spain";
	private LinkedHashMap<String, String> address;
	
	public ESAddress() {
		this.address = super.askForAddress();
	}


	@Override
	public String getField(String field) {
		switch (field.toUpperCase()) {
		case "COUNTRY":
			return ESAddress.COUNTRY;
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
		return ESAddress.field.valueOf(field).isMandatory;
	}

	@Override
	public String getFieldRegex(String field) {
		return ESAddress.field.valueOf(field).regex;
	}

	@Override
	public String getAddress() {
		return String.format("%s %s, %s %s%n%s - %s%n%s",
				this.getField("STREET"), this.getField("NUMBER"),
				this.getField("FLAT"), this.getField("APPARTMENT"),
				this.getField("POSTAL_CODE"), this.getField("CITY"),
				ESAddress.COUNTRY
				);
	}
	
	

}
