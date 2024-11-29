package com.springboot.bank_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bank_demo.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
