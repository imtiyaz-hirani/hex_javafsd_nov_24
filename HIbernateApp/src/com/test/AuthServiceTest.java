package com.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.hibernate.service.AuthService;
import com.hibernate.utility.FactoryUtility;

import jakarta.persistence.EntityManager;
 

public class AuthServiceTest {

	EntityManager entityManager = FactoryUtility.getInstance().loadPersistence();
	AuthService authService = new AuthService(entityManager);
	
	@Test
	public void checkIfAdminTest() {
		//use case 1- pass valid credentials 
		boolean actualResult = authService.checkIfAdmin("admin1", "admin1");
		boolean expectedResult = true; 
		
		Assert.assertEquals(expectedResult, actualResult);
		//use case 2: pass invalid credentials 
		actualResult = authService.checkIfAdmin("admin", "1234");
		expectedResult = false; 
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void checkIfUsernameUniqueTest() {
		boolean actualResult = authService.checkIfUsernameUnique("harry@gmail.com");
		boolean expectedResult = false;
		Assert.assertEquals(expectedResult, actualResult);
		
		actualResult = authService.checkIfUsernameUnique("jack@gmail.com");
		expectedResult = true;
		Assert.assertEquals(expectedResult, actualResult);
	}
}
