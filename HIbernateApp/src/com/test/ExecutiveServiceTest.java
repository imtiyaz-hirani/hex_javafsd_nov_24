package com.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.hibernate.exception.ResourceNotFoundException;
import com.hibernate.model.Executive;
import com.hibernate.service.ExecutiveService;
import com.hibernate.utility.FactoryUtility;

import jakarta.persistence.EntityManager;
 
public class ExecutiveServiceTest {

	EntityManager entityManager = FactoryUtility.getInstance().loadPersistence();
	ExecutiveService executiveService = new ExecutiveService(entityManager);
	
	@Test 
	public void checkLogintest() {
		//use case 1: valid credentials 
		try {
			Executive actualExecutive =   executiveService.checkLogin("harry@gmail.com", "123456");
			Executive expectedExecutive = new Executive();
			expectedExecutive.setName("harry potter");
			expectedExecutive.setId(600193363);
			Assert.assertEquals(expectedExecutive.getName().toLowerCase(), actualExecutive.getName().toLowerCase());
			Assert.assertEquals(expectedExecutive.getId(), actualExecutive.getId());
			
		} catch (ResourceNotFoundException e) { }
		
		//use case 2: invalid credentials 
		Exception ex = Assert.assertThrows(ResourceNotFoundException.class, ()->{
			executiveService.checkLogin("jack@gmail.com", "123456");
		});
		
		Assert.assertEquals("Invlid Credentials..", ex.getMessage());
	}
}
