package challenge.services;

import challenge.model.User;

/**
 * 
 * @author Nicolas Rodriguez
 * @since 1.0.0
 *
 */
public interface LoginService {
	
	/**
	 * Returns an user when authentication is successful, throws exception if not.
	 * 
	 * @param the username.
	 * @param the password-
	 * @return {@link challenge.model.User}
	 */
	User login(String username, String password);

}
