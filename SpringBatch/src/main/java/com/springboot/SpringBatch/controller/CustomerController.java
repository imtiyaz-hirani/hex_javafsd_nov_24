package com.springboot.SpringBatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.SpringBatch.model.Customer;
import com.springboot.SpringBatch.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/customer/post")
	public Customer postCustomer(@RequestBody Customer customer) {
		return customerService.postCustomer(customer);
	}
}
