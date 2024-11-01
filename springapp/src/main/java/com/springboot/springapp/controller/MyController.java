package com.springboot.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
 
import com.springboot.springapp.service.MyService;

@Controller
public class MyController {
	
	@Autowired
	private MyService myService;   //DI 
	
	@GetMapping("/")   //@RequestMapping 
	public String showLogin() {
		// System.out.println("login method in controller called....");
		return "login";
	}
}
