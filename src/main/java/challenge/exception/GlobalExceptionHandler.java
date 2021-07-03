package challenge.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Handles exceptions thrown from controller layer.
 * 
 * @author Nicolas Rodriguez
 * @since 1.0.0
 *
 */
@ControllerAdvice
class GlobalExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<String> handleLoginException(LoginException ex) {
		logger.warn("Error in user login: " + ex.getMessage());
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized: " + ex.getMessage());
	}
	
	@ExceptionHandler(ProvincesResponseException.class)
	public ResponseEntity<String> handleProvincesResponseException(ProvincesResponseException ex) {
		logger.error("Error or unexpected value in provinces api response: " + ex.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error: " + ex.getMessage());
	}

}
