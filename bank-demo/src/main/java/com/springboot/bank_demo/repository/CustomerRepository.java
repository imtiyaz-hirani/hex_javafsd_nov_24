package com.springboot.bank_demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.bank_demo.model.Account;
import com.springboot.bank_demo.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	@Query("select a from Account a "
			+ "	join a.customer c "
			+ " join c.user u "
			+ " where u.username=?1")
	List<Account> getAccountByCustomerUsername(String username);

	@Query("select c from Account a "
			+ " join a.customer c "
			+ " where a.accountNum=?1")
	Customer getCustomerNameByAccountNumber(String accountNumber);

	@Query("select c from Customer c "
			+ " join c.user u "
			+ " where u.username=?1")
	Customer getCustomerDetailsByUsername(String username);

}
/*
 * Account (P)
 * Customer (C)
 * 
 * Customer (C) --name
 * Account (A)
 * 
 * 
 * Customer (P)
 * User (C) - username
 */