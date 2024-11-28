package com.springboot.bank_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bank_demo.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

}
