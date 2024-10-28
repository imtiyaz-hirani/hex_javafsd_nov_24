package com.hibernate.service;

import java.util.Scanner;

import com.hibernate.model.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ProductService {

	private EntityManager entityManager;
	private EntityTransaction entityTransaction;
	
	public ProductService(EntityManager entityManager, EntityTransaction entityTransaction) {
		this.entityManager = entityManager;
		this.entityTransaction = entityTransaction;
	}


	public Product takeInput(Scanner sc) {
		Product product = new Product();
		System.out.println("Enter Product Title");
		sc.nextLine();
		product.setTitle(sc.nextLine());
		System.out.println("Enter description");
		product.setDescription(sc.nextLine());
		System.out.println("Enter price");
		product.setPrice(sc.nextDouble());
		return product;
	}
	
	public void insert(Product product) {
		entityTransaction.begin();
		entityManager.persist(product);
		entityTransaction.commit();
	}


}
