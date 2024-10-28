package com.hibernate.controller;

import java.util.Scanner;

import com.hibernate.model.Customer;
import com.hibernate.service.CustomerService;
import com.hibernate.utility.FactoryUtility;

import jakarta.persistence.EntityManager;

public class CustomerController {
	public static void main(String[] args) {
		EntityManager entityManager = FactoryUtility.getInstance().loadPersistence();
		Scanner sc = new Scanner(System.in);
		CustomerService customerService = new CustomerService(entityManager,entityManager.getTransaction());
		while(true) {
			System.out.println("------------Product MENU--------------");
			System.out.println("1. Enter Customer with Address in DB");
			System.out.println("2. Fetch All Customer with Address");
			System.out.println("0. Exit");
			int input =sc.nextInt();
			if(input == 0 ) {
				System.out.println("Exiting.. thank you");
				break; 
			}
			
			switch(input) {
			case 1: 
				//take input
				Customer customer = customerService.takeInputAndGenerateId(sc);
				//save address 
				customerService.saveAddress(customer.getAddress());
				//save customer 
				customerService.saveCustomer(customer);
				System.out.println("Customer with address added to DB");
				break; 
			default: 
				System.out.println("Invalid Input, Try Again!!");
				break;
			}
		}
		sc.close();
	}
}
