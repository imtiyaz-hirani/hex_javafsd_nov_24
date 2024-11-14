package com.springboot.SpringBatch.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.SpringBatch.exception.ResourceNotFoundException;
import com.springboot.SpringBatch.model.Customer;
import com.springboot.SpringBatch.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer postCustomer(Customer customer) {
		 
		return customerRepository.save(customer);
	}
	
	public Customer getById(int id) throws ResourceNotFoundException {
		Optional<Customer> optional = customerRepository.findById(id);
		if(optional.isEmpty())
			throw new ResourceNotFoundException("Customer id Invalid");
		
		return optional.get();
	}
	
	
	public List<Customer> saveAllCustomers(List<Customer> list) {
		return customerRepository.saveAll(list);
	}
}









