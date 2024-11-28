package com.springboot.bank_demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bank_demo.dto.TransactionDto;
import com.springboot.bank_demo.exception.ResourceNotFoundException;
import com.springboot.bank_demo.model.Account;
import com.springboot.bank_demo.model.Customer;
import com.springboot.bank_demo.model.Transaction;
import com.springboot.bank_demo.model.User;
import com.springboot.bank_demo.service.CustomerService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	/*
	 * RequestBody: 
	  name: "",
	 contact: "",
	  user: {
	  	"username" : "",
	   "password": "",
	 
	  }
	 * */
	@PostMapping("/api/customer/add")
	public Customer addCustomer(@RequestBody Customer customer ) {
		//insert user first and then customer 
		User user = customer.getUser(); //username , password 
		user = customerService.insertUser(user); //id, username, password, role 
		
		//attach to customer 
		customer.setUser(user);
		
		return customerService.insertCustomer(customer); 
	}
	
	/*
	 customer_id
	 
	 accountNum, accountType, dateOfCreation, balance, transferLimit
	 * */
	@PostMapping("/api/create-account/{customerId}")
	public Account createCustomerAccount(@PathVariable int customerId, 
									  @RequestBody Account account) throws ResourceNotFoundException {
		
		Customer customer =  customerService.getCustomer(customerId);
		account.setDateOfCreation(LocalDate.now());
		account.setCustomer(customer);
		return customerService.insertAccount(account);
	}
	
	@GetMapping("/api/account/customer")
	public List<Account> getAccountByCustomerUsername(@RequestParam String username) {
		return customerService.getAccountByCustomerUsername(username);
	}
	
	@GetMapping("/api/customer/account")
	public Customer getCustomerNameByAccountNumber(@RequestParam String accountNumber) {
		return customerService.getCustomerNameByAccountNumber(accountNumber);
	}
	
	@PostMapping("/api/transaction/add")
	public Transaction postTransaction(@RequestBody TransactionDto dto) {
		System.out.println(dto);
		return customerService.postTransaction(dto);
	}
}
