package com.springboot.SpringBatch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.SpringBatch.exception.ResourceNotFoundException;
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
	
	private List<Customer> list; 
	
	@BeforeEach
	public void initSetup() {
		customer = new Customer(1,"harry potter","57878478457","london");
		list = Arrays.asList(customer, new Customer(2,"ronald","8896756453","surrey"));
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
	
	@Test
	public void getByIdTest() {
		//arrange
		when(customerRepository.findById(1)).thenReturn(Optional.of(customer));
		
		//act
		Customer newCustomer = null;
		try {
			newCustomer =  customerService.getById(1);
		} catch (ResourceNotFoundException e) { }
		
		//test 
		assertNotNull(newCustomer);
		assertEquals(customer.getName(), newCustomer.getName());
		
		//verify that repository method is getting called only once
		verify(customerRepository, times(1)).findById(1);
	}
	
	@Test
	public void getByIdTestNotExist(){
		//arrange
		when(customerRepository.findById(2)).thenReturn(Optional.empty());
		
		//act
				Customer newCustomer = null;
				try {
					newCustomer =  customerService.getById(2);
				} catch (ResourceNotFoundException e) { 
					assertEquals("Customer id Invalid".toLowerCase(),
							e.getMessage().toLowerCase());
				}
			assertNull(newCustomer);
			
		//verify that repository method is getting called only once
		verify(customerRepository, times(1)).findById(2);
	}
	
	@Test
	public void saveAllEmployeeTest() {
		//arrange
		when(customerRepository.saveAll(anyList())).thenReturn(list);
		
		//act
		List<Customer> newList =  customerService.saveAllCustomers(list);
		
		//test
		assertNotNull(newList);
		assertEquals(2, newList.size());
		assertEquals("london", newList.get(0).getCity().toLowerCase());
		
		//verify that repository method is getting called only once
		verify(customerRepository, times(1)).saveAll(anyList());
	}
	
	@Test
	public void deleteCustomerByIdTestSuccess() throws ResourceNotFoundException {
		//arrange
		when(customerRepository.findById(1)).thenReturn(Optional.of(customer));
		
		//Act
		customerService.deleteCustomerById(1);
		
		 
		//verify that repository method is getting called only once
		verify(customerRepository, times(1)).deleteById(1);
	}
	
	
	@Test
	public void deleteCustomerByIdTestFailure() throws ResourceNotFoundException {
		//arrange
		when(customerRepository.findById(2)).thenReturn(Optional.empty());
		
		//Act
		 assertThrows(ResourceNotFoundException.class, 
				 ()->customerService.deleteCustomerById(2) );
		
		 //verify that repository method is getting called only once
		verify(customerRepository, never()).deleteById(2);
	}
}















