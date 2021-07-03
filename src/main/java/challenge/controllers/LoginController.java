package challenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import challenge.model.LoginForm;
import challenge.services.LoginService;

/**
 * 
 * @author Nicolas Rodriguez
 * @since 1.0.0
 *
 */
@RestController
@RequestMapping("/login")
class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping
	public ResponseEntity<Object> login(@RequestBody LoginForm loginForm) {
		return ResponseEntity.ok(loginService.login(loginForm.getUsername(), loginForm.getPassword()));
	}

}
