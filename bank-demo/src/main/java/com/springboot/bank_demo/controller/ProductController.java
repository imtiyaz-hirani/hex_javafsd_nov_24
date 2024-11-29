package com.springboot.bank_demo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.bank_demo.exception.ResourceNotFoundException;
import com.springboot.bank_demo.model.Product;
import com.springboot.bank_demo.model.ProductImage;
import com.springboot.bank_demo.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/api/product/add")
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}
	
	@PostMapping("/api/product/image/upload/{pid}")
	public ProductImage uloadImage(@PathVariable int pid, @RequestParam MultipartFile file) 
	throws IOException, ResourceNotFoundException{
		
		return productService.uploadImage(pid,file);
		
		
	}
}







