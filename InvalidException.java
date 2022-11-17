public class InvalidException extends Exception {
	/**
	 * Constructor.
	 */
	public InvalidException() {
		this("Invalid");
	}
	
	/**
	 * Parameterized constructor.
	 * @param message String message to be shown.
	 */
	public InvalidException(String message) {
		super(message);
	}
}