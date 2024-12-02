package com.springboot.bank_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bank_demo.model.Company;

public interface CompanyRepo extends JpaRepository<Company, Integer> {

}
