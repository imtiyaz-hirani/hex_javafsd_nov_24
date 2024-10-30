package com.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.hibernate.service.MyService;

public class MyServiceTest {
	
	MyService myService = new MyService();
	
	 
	@Test
	public void computePercentTest() {
		//Use Case 1
		List<Double> listMarks = Arrays.asList(78d,67d,71d,94.0);
		double totalmarks = 400; 
		
		double actualResult = myService.computePercent(listMarks, totalmarks);
		double expectedResult = 77.5d;
		
		Assert.assertEquals(expectedResult,actualResult,0.01);
		
		//Use Case 2
		listMarks = Arrays.asList(78d,0.0,71d,45.0);
		actualResult = myService.computePercent(listMarks, totalmarks);
		expectedResult = 48.5d;
		Assert.assertEquals(expectedResult,actualResult,0.001);
		
		//Use Case 2
		listMarks = Arrays.asList(78d);
		totalmarks = 90;
		actualResult = myService.computePercent(listMarks, totalmarks);
		expectedResult = 86.66;
		Assert.assertEquals(expectedResult,actualResult,0.01);
	}
}
