package com.springboot.SpringBatch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.SpringBatch.model.Customer;
import com.springboot.SpringBatch.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer postCustomer(Customer customer) {
		 
		return customerRepository.save(customer);
	}
}
