package com.springboot.JWTSecurity.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.JWTSecurity.JwtUtil;
import com.springboot.JWTSecurity.dto.JwtDto;
import com.springboot.JWTSecurity.dto.ResponseMessageDto;
import com.springboot.JWTSecurity.exception.InvalidUsernameException;
import com.springboot.JWTSecurity.model.User;
import com.springboot.JWTSecurity.service.UserSecurityService;
import com.springboot.JWTSecurity.service.UserService;
@RestController 
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private UserSecurityService userSecurityService;
	@Autowired
	private UserService userService;
	
	@PostMapping("/api/token")
	public ResponseEntity<?> getToken(@RequestBody User user, JwtDto dto ) {
		try {
		Authentication auth 
				= new UsernamePasswordAuthenticationToken
							(user.getUsername(), user.getPassword());
		
		authenticationManager.authenticate(auth);
		
		/*Check if username is in DB */
		user = (User) userSecurityService.loadUserByUsername(user.getUsername());
		
		String jwt = jwtUtil.generateToken(user.getUsername());
		dto.setUsername(user.getUsername());
		dto.setToken(jwt);
		return ResponseEntity.ok(dto);
		}
		catch(AuthenticationException ae) {
			return ResponseEntity.badRequest().body(ae.getMessage());
		}
	}
	
	@GetMapping("/api/hello")
	public String sayHello(Principal principal) {
		String user = "";
		if(principal == null) {
			user = "TEMP_USER";
		}
		else {
			user = principal.getName();
		}
		return "api accessed by: " + user;
	}
	
	@PostMapping("/auth/sign-up")
	public ResponseEntity<?> signUp(@RequestBody User user,ResponseMessageDto dto){
		try {
			return ResponseEntity.ok(userService.signUp(user));
		} catch (InvalidUsernameException e) {
			dto.setMsg(e.getMessage());
			 return ResponseEntity.badRequest().body(dto);
		}
	}
	
	@GetMapping("/api/executive/hello")
	public String sayHelloExec(Principal principal) {
		String user = "";
		if(principal == null) {
			user = "TEMP_USER";
		}
		else {
			user = principal.getName();
		}
		return "api accessed by: " + user;
	}
}
