package com.springboot.SpringBatch.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	private String name; 
	private String contact; 
	private String city;
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int id, String name, String contact, String city) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.city = city;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	} 
	
	
}
