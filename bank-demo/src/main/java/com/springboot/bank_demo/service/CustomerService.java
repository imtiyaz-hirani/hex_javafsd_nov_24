package com.springboot.bank_demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.bank_demo.dto.TransactionDto;
import com.springboot.bank_demo.exception.ResourceNotFoundException;
import com.springboot.bank_demo.model.Account;
import com.springboot.bank_demo.model.Customer;
import com.springboot.bank_demo.model.Transaction;
import com.springboot.bank_demo.model.User;
import com.springboot.bank_demo.repository.AccountRepository;
import com.springboot.bank_demo.repository.CustomerRepository;
import com.springboot.bank_demo.repository.TransactionRepository;
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
	@Autowired
	private TransactionRepository transactionRepository;
	
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

	public Transaction postTransaction(TransactionDto dto) {
		Account senderAccount =  accountRepository
					.findByAccountNum(dto.getSenderAccountnumber()).get();
		Account beneficiaryAccount = accountRepository
					.findByAccountNum(dto.getBeneficiaryAccountNumber()).get();
		
		//update sender account 
		senderAccount.setBalance(senderAccount.getBalance() - dto.getAmount());
		senderAccount = accountRepository.save(senderAccount);
		//update beneficiary account 
		beneficiaryAccount.setBalance(beneficiaryAccount.getBalance() + dto.getAmount());
		beneficiaryAccount = accountRepository.save(beneficiaryAccount);
		
		Transaction transaction = new Transaction();
		transaction.setSenderAccount(senderAccount);
		transaction.setBeneficiaryAccount(beneficiaryAccount);
		transaction.setDateOfTransfer(dto.getDateOfTransfer());
		transaction.setAmount(dto.getAmount());
		transaction.setModeOfTransfer(dto.getModeOfTransfer());
		
		return transactionRepository.save(transaction);
	}

}
