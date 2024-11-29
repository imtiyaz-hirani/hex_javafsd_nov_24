package com.springboot.bank_demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.bank_demo.dto.ProductDto;
import com.springboot.bank_demo.exception.ResourceNotFoundException;
import com.springboot.bank_demo.model.Product;
import com.springboot.bank_demo.model.ProductImage;
import com.springboot.bank_demo.service.ProductService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
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
	
	@GetMapping("/api/product/all")
	public List<ProductDto> getAllProducts() {
		List<Product> pList =  productService.getAllProducts();
		List<ProductImage> imageList= productService.getAllProductImages();
		
		List<ProductDto> listDto = new ArrayList<>();
		for(Product p : pList) {
			ProductDto dto = new ProductDto();
			dto.setId(p.getId());
			dto.setTitle(p.getTitle());
			dto.setPrice(p.getPrice());
			
			List<ProductImage> iList =
					imageList.stream()
						.filter(i->i.getProduct().getId() == p.getId())
						.toList();
			dto.setImages(iList);
			listDto.add(dto);
		}
		
		return listDto;
	}
	@GetMapping("/product/one/{id}")
	public ProductDto getById(@PathVariable int id) throws ResourceNotFoundException {
		 Product p = productService.getById(id);
			List<ProductImage> imageList= productService.getAllProductImages();

		 ProductDto dto = new ProductDto();
		 dto.setId(p.getId());
			dto.setTitle(p.getTitle());
			dto.setPrice(p.getPrice());
			List<ProductImage> iList =
					imageList.stream()
						.filter(i->i.getProduct().getId() == p.getId())
						.toList();
			dto.setImages(iList);
			 
			return dto; 
	}
}







