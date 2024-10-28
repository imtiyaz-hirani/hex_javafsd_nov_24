package com.hibernate.service;

import java.util.List;
import java.util.Scanner;

import com.hibernate.model.Address;
import com.hibernate.model.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class CustomerService {

	private EntityManager entityManager;
	private EntityTransaction entityTransaction;
	
	public CustomerService(EntityManager entityManager, EntityTransaction transaction) {
		this.entityManager = entityManager;
		this.entityTransaction = transaction;
	}

	public Customer takeInputAndGenerateId(Scanner sc) {
		Customer customer = new Customer();
		 System.out.println("Enter Name");
		 sc.nextLine();
		 customer.setName(sc.nextLine());
		 System.out.println("Enter Age");
		 customer.setAge(sc.nextInt());
		 int customerId =(int) (Math.random()*1000000000);
		 customer.setId(customerId);
		 
		 System.out.println("------Address Info--------");
		 Address address = new Address();
		 System.out.println("Enter city");
		 sc.nextLine();
		 address.setCity(sc.nextLine());
		 System.out.println("Enter state");
		 address.setState(sc.nextLine());
		 int addressId =(int) (Math.random()*10000000);
		 address.setId(addressId);
		 
		 customer.setAddress(address);
		return customer;
	}

	public void saveAddress(Address address) {
		entityTransaction.begin();
		entityManager.persist(address);
		entityTransaction.commit();
		
	}

	public void saveCustomer(Customer customer) {
		entityTransaction.begin();
		entityManager.persist(customer);
		entityTransaction.commit();
		
	}

	public List<Customer> fetchAllCustomer() {
		entityTransaction.begin();
		TypedQuery <Customer> customers = entityManager.createQuery("select c from Customer c", Customer.class);
		entityTransaction.commit();
		return customers.getResultList();
	}
	
	/*
	 * select * from customer 
	 * select c from Customer c 
	 * */
	
	

}
