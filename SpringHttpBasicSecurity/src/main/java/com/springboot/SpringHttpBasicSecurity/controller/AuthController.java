package com.springboot.SpringHttpBasicSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.SpringHttpBasicSecurity.service.UserService;

@RestController
public class AuthController {

	@Autowired
	private UserService userService;
}
