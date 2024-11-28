package com.springboot.bank_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bank_demo.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
