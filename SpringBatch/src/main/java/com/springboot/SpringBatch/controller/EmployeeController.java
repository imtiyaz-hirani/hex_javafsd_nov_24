package com.springboot.SpringBatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.SpringBatch.service.AddressService;
import com.springboot.SpringBatch.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/api/employee/batch-insert")
	public void uploadEmployeethruExcel() {
		
	}
}
