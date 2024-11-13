package com.springboot.SpringBatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.SpringBatch.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
