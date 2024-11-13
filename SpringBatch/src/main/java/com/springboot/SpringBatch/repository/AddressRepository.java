package com.springboot.SpringBatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.SpringBatch.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
