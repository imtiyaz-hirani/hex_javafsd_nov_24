package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.hibernate.model.Product;
import com.hibernate.service.ProductService;
import com.hibernate.utility.FactoryUtility;

import jakarta.persistence.EntityManager;

public class ProductServiceTest {
	EntityManager entityManager = FactoryUtility.getInstance().loadPersistence();
	ProductService productService = new ProductService(entityManager, entityManager.getTransaction());

	@Test
	public void getAllTest(){
		List<Product> actualList =  productService.getAll();
		Assert.assertNotNull(actualList);
		int expectedSize = 2; 
		assertEquals(expectedSize, actualList.size());
	}
			
}
