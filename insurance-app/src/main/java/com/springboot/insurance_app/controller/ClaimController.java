package com.springboot.insurance_app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClaimController {

	@PostMapping("/claim/process")
	public void processClaim() {
		
	}
}
