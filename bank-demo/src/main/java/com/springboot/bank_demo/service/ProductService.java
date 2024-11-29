package com.springboot.bank_demo.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.bank_demo.exception.ResourceNotFoundException;
import com.springboot.bank_demo.model.Product;
import com.springboot.bank_demo.model.ProductImage;
import com.springboot.bank_demo.repository.ProductImageRepo;
import com.springboot.bank_demo.repository.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private ProductImageRepo productImageRepo;

	public Product addProduct(Product product) {
		
		return productRepo.save(product);
	}

	public ProductImage addProductImage(ProductImage pi) {
		 
		return productImageRepo.save(pi);
	}

	public Product getById(int pid) throws ResourceNotFoundException {
		Optional<Product> optional =   productRepo.findById(pid);
		if(optional.isEmpty())
			throw new ResourceNotFoundException("Invalid Product ID");
		
		return optional.get();
		  
		 
	}

	public ProductImage uploadImage(int pid, MultipartFile file) throws IOException, ResourceNotFoundException {
		System.out.println(file.getOriginalFilename());
		String location = "D:/hex_javafsd_nov_24/bank-proj-ui/public/images";
		Path path = Path.of(location, file.getOriginalFilename()); 
		//System.out.println(path.toString());
		try {
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			throw e; 
		}
		
		Product product=null;
		try {
			product = getById(pid);
		} catch (ResourceNotFoundException e) {
			 throw e; 
		}
		
		ProductImage pi = new ProductImage();
		pi.setFileName(file.getOriginalFilename());
		pi.setPath(path.toString());
		pi.setProduct(product);
		
		return addProductImage(pi);
	}
	
	
}
