package com.springboot.bank_demo.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.bank_demo.model.ProductImage;

@Component
public class ProductDto {

	private int id;
	private String title;
	private double price;
	List<ProductImage> images;

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<ProductImage> getImages() {
		return images;
	}

	public void setImages(List<ProductImage> images) {
		this.images = images;
	}

}
