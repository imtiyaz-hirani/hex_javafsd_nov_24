package com.springboot.bank_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bank_demo.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

}
