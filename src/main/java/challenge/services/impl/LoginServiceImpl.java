package challenge.services.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import challenge.exception.LoginException;
import challenge.model.User;
import challenge.services.LoginService;

/**
 * 
 * @author Nicolas Rodriguez
 * @since 1.0.0
 *
 */
@Service
public class LoginServiceImpl implements LoginService {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Value("${user.username}")
	private String validUsername;
	
	@Value("${user.password}")
	private String validPassword;

	@Override
	public User login(String username, String password) {
		if(!validUsername.equals(username) || !validPassword.equals(password)) {
			throw new LoginException("Invalid username or password.");
		}
		User user = new User();
		user.setUsername(username);
		user.setLoginDate(new Date());
		
		logger.debug("Successful user login: " + user.toString());
		
		return user;
	}

}
