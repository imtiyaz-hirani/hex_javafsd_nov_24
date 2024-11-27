package com.springboot.bank_demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.bank_demo.exception.ResourceNotFoundException;
import com.springboot.bank_demo.model.Account;
import com.springboot.bank_demo.model.Customer;
import com.springboot.bank_demo.model.User;
import com.springboot.bank_demo.repository.AccountRepository;
import com.springboot.bank_demo.repository.CustomerRepository;
import com.springboot.bank_demo.repository.UserRepository;

@Service
public class CustomerService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private AccountRepository accountRepository;
	
	public User insertUser(User user) {
		user.setRole("CUSTOMER");
		//password to encrypted Type
		String encPass = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(encPass);
		
		return userRepository.save(user);
	}

	public Customer insertCustomer(Customer customer) {
		 
		return customerRepository.save(customer);
	}

	public Customer getCustomer(int customerId) throws ResourceNotFoundException {
		Optional<Customer> optional =  customerRepository.findById(customerId);
		 if(optional.isEmpty())
			 throw new ResourceNotFoundException("Invalid ID Given");
		
		 return optional.get();
	}

	public Account insertAccount(Account account) {
		return accountRepository.save(account);
	}

	public List<Account> getAccountByCustomerUsername(String username) {
		
		return customerRepository.getAccountByCustomerUsername(username);
	}

	public Customer getCustomerNameByAccountNumber(String accountNumber) {
		 
		return customerRepository.getCustomerNameByAccountNumber(accountNumber);
	}

}
