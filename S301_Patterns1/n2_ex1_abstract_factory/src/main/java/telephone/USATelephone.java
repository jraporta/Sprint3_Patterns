package telephone;

import exeptions.TelephoneFormatException;

public class USATelephone extends Telephone{
	
	private static final String REGEX = "^\\+1[0-9]{10}$";
	private static final String COUNTRY = "USA";
	private static final String EXPLANATION = 
			"A telephone from the USA should be +1 followed by a 10-digit number.";

	public USATelephone(String telephoneNumber) throws TelephoneFormatException {
		super(telephoneNumber);
	}

	@Override
	public String getCountry() {
		return USATelephone.COUNTRY;
	}

	@Override
	protected String getRegex() {
		return USATelephone.REGEX;
	}

	@Override
	protected String getFormatExplanation() {
		return USATelephone.EXPLANATION;
	}

}
