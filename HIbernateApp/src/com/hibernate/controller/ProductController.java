package com.hibernate.controller;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.hibernate.exception.InvalidIdException;
import com.hibernate.model.Product;
import com.hibernate.service.ProductService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ProductController {

	public static void main(String[] args) {
		 
		//step 1
		 //from here i need to reach out to persistence.xml : 
		SessionFactory sessionFactory = (SessionFactory)
						Persistence.createEntityManagerFactory("myecomapp");
		//step 2
		EntityManager entityManager =  sessionFactory.createEntityManager();
		
		//step 3
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Scanner sc = new Scanner(System.in);
		
		ProductService productService = new ProductService(entityManager,entityTransaction);
		while(true) {
			System.out.println("------------Product MENU--------------");
			System.out.println("1. Enter Product in DB");
			System.out.println("2. Fetch All Products");
			System.out.println("3. Delete Product");
			System.out.println("4. Update Product Details");
			System.out.println("0. Exit");
			int input =sc.nextInt();
			if(input == 0 ) {
				System.out.println("Exiting.. thank you");
				break; 
			}
			switch(input) {
			case 1:
				Product product = productService.takeInput(sc);
				productService.insert(product);
				System.out.println("Product added to DB..");
				break; 
			case 3: 
				try {
					product = productService.getById(sc);
					productService.delete(product);
					System.out.println("Product deleted from DB...");
				} catch (InvalidIdException e) {
					 System.out.println(e.getMessage());
				}
				break; 
			default: 
				System.out.println("Invalid Input, Try Again!!");
				break;
			}
			System.out.println("--------------------------------------");
		}
		
		
		sc.close();
	}

}
