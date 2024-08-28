package exeptions;

public class TelephoneFormatException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public TelephoneFormatException(String message) {
		super("TelephoneFormatException: " + message);
	}
	
}
