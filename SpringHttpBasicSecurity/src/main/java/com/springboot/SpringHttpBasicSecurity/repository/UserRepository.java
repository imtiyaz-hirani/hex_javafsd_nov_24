package com.springboot.SpringHttpBasicSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.SpringHttpBasicSecurity.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
