package challenge.services.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import challenge.exception.LoginException;
import challenge.model.User;
import challenge.services.LoginService;

/**
 * Unit test for LoginServiceImpl class.
 * 
 * @author Nicolas Rodriguez
 * @since 1.0.0
 *
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = LoginServiceImpl.class)
@TestPropertySource(properties = {"user.username=A", "user.password=B"})
public class LoginServiceImplTest {
	
	@Autowired
	private LoginService loginService;
	
	@Test
	public void loginSuccessTest() {
		User u = loginService.login("A", "B");
		
		Assertions.assertNotNull(u);
		Assertions.assertTrue(u.getUsername().equals("A"));
	}
	
	@Test
	public void loginFailureTest() {
		Assertions.assertThrows(LoginException.class, () -> loginService.login("C", "C"));
	}

}
