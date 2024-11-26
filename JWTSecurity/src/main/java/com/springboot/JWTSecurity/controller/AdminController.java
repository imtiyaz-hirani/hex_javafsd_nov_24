package com.springboot.JWTSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.JWTSecurity.dto.UserCountStatDto;
import com.springboot.JWTSecurity.service.UserService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class AdminController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/api/users-stat")
	public UserCountStatDto getUserStats() {
		return userService.getUserStats();
	}
}
