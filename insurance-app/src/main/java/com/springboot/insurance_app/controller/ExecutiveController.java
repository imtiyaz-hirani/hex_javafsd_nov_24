package com.springboot.insurance_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.insurance_app.model.Executive;
import com.springboot.insurance_app.service.ExecutiveService;

@RestController
public class ExecutiveController {

	@Autowired
	private ExecutiveService executiveService;
	
	@PostMapping("/executive/add")
	public Executive inser(@RequestBody Executive executive) {
		return executiveService.insert(executive);
	}
}
