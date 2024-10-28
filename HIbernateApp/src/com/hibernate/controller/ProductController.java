package com.hibernate.controller;

import java.util.List;
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
			case 2: 
				List<Product> list = productService.getAll();
				list.stream().forEach(System.out :: println);
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
			case 4:
				try {
					product = productService.getById(sc);
					System.out.println("Current Product Details: ");
					System.out.println(product);
					System.out.println("Enter Title("+ product.getTitle()  +") "
							+ " Press Y to retain current value else type new value: ");
					sc.nextLine();
					String title = sc.nextLine();
					if(!title.equals("Y"))
						product.setTitle(title);
					
					System.out.println("Enter Description(Press Y to retain current value else type new value)");
					String description = sc.nextLine();
					if(!description.equals("Y"))
						product.setDescription(description);
					
					System.out.println("Enter Price("+ product.getPrice()  +") "
							+ " Press Y to retain current value else type new value: ");
					String priceStr = sc.next(); 
					if(!priceStr.equals("Y"))
						product.setPrice(Double.parseDouble(priceStr));
					
					productService.insert(product);
					System.out.println("Product details Updated..");
				} catch (InvalidIdException e) {
					System.out.println(e.getMessage());
				}
				break; 
			default: 
				System.out.println("Invalid Input, Try Again!!");
				break;
			}
 		}
		
		
		sc.close();
	}

}
