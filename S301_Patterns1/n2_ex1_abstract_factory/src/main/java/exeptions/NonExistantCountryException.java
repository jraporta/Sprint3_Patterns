package exeptions;

public class NonExistantCountryException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public NonExistantCountryException() {
		super("NonExistantCountryException: Country not recognized by the app.");
	}
	
	public NonExistantCountryException(String s) {
		super("NonExistantCountryException: " + s);
	}

}
