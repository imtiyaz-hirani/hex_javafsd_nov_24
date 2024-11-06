package com.springboot.insurance_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.insurance_app.model.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Integer>{

	 

}

/*
 * T save(T)  
 * List<T> findAll()  
 */