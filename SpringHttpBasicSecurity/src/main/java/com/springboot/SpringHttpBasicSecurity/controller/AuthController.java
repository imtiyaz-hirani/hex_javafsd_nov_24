package com.springboot.SpringHttpBasicSecurity.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.springboot.SpringHttpBasicSecurity.service.UserService;

@RestController
public class AuthController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/api/hello")
	public String sayHello(Principal principal) {
		
		return "api accessed by: " + principal.getName();
	}
}
