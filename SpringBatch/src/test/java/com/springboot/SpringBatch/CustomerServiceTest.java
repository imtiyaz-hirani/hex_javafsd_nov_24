package com.springboot.SpringBatch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.SpringBatch.model.Customer;
import com.springboot.SpringBatch.repository.CustomerRepository;
import com.springboot.SpringBatch.service.CustomerService;

@SpringBootTest
public class CustomerServiceTest {

	@InjectMocks
	private CustomerService customerService;
	@Mock
	private CustomerRepository customerRepository;
	
	private Customer customer;
	
	@BeforeEach
	public void initSetup() {
		customer = new Customer(1,"harry potter","57878478457","london");
	}
	
	@Test
	public void postCustomerTest() {
		//arrangement using mocking 
		when(customerRepository.save(customer)).thenReturn(customer);
		
		//Act : Calling the actual method 
		Customer newCustomer =   customerService.postCustomer(customer); 
		
		//test and compare 
		assertNotNull(newCustomer);
		//assertEquals(customer.getName(), newCustomer.getName());
		verify(customerRepository, times(1)).save(customer);
	}
}
