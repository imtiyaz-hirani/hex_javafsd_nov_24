package com.springboot.SpringBatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.SpringBatch.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
