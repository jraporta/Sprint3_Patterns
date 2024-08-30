package exeptions;

public class AddressFormatException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public AddressFormatException(String message) {
		super("AddressFormatException: " + message);
	}
	
}
