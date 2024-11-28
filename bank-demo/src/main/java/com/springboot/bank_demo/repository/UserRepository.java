package com.springboot.bank_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bank_demo.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}