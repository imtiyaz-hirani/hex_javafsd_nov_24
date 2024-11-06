package com.springboot.insurance_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.insurance_app.model.Policy;
import com.springboot.insurance_app.service.PolicyService;

@RestController
public class PolicyController {

	@Autowired
	private PolicyService policyService;
	
	@PostMapping("/policy/add")
	public Policy addPolicy(@RequestBody Policy policy) {
		 //System.out.println(policy);
		return policyService.insert(policy);
	}
	
	@GetMapping("/policy/all")
	public List<Policy> getAllPolicy() {
		List<Policy> list = policyService.getAllPolicy();
		return list;
	}
}
/*
 * GET : @GetMapping
 * POST: @PostMapping
 * PUT/update: @PutMapping
 * DELETE: @DeleteMapping 
 * 
 */