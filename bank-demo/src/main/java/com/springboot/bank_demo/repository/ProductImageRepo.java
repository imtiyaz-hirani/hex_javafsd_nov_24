package com.springboot.bank_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bank_demo.model.ProductImage;

public interface ProductImageRepo extends JpaRepository<ProductImage, Integer>{

}
