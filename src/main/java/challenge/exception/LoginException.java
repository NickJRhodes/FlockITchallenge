package challenge.exception;

/**
 * 
 * @author Nicolas Rodriguez
 * @since 1.0.0
 *
 */
public class LoginException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public LoginException(String message) {
		super(message);
	}

}
