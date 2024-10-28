package com.hibernate.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity //<-- this will create the table in the db with name as "product"
public class Product {
	@Id  //<-- this will create a primary key id in the table 
	@GeneratedValue(strategy = GenerationType.AUTO) //<-- this makes id auto incremental 
	private int id; 
	
	@Column(nullable = false)
	private String title; 
	
	@Column(length = 1000)
	private String description; 
	
	@Column(nullable = false)
	private double price; 
	
	private LocalDate postedOn = LocalDate.now();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getPostedOn() {
		return postedOn;
	}

	public void setPostedOn(LocalDate postedOn) {
		this.postedOn = postedOn;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", description=" + description + ", price=" + price
				+ ", postedOn=" + postedOn + "]";
	}
	
	
	
}
