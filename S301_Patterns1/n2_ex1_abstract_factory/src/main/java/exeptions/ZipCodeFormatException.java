package exeptions;

public class ZipCodeFormatException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ZipCodeFormatException(String message) {
		super("ZipCodeFormatException: " + message);
	}
	
}
