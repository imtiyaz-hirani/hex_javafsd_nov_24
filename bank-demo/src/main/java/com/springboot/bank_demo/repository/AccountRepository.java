package com.springboot.bank_demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bank_demo.model.Account;
import com.springboot.bank_demo.model.Customer;

public interface AccountRepository extends JpaRepository<Account, Integer>{

	Optional<Account> findByAccountNum(String senderAccountnumber);

}
