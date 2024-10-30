package com.test;

 
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.hibernate.exception.InvalidMarksException;
import com.hibernate.service.MyService;

public class MyServiceTest {
	
	MyService myService = new MyService();
	
	@Test
	public void computePercentTest() {
		//Use Case 1
		List<Double> listMarks = Arrays.asList(78d,67d,71d,94.0);
		double totalmarks = 400; 
		
		double actualResult;
		try {
			actualResult = myService.computePercent(listMarks, totalmarks);
			double expectedResult = 77.5d;
			
			Assert.assertEquals(expectedResult,actualResult,0.01);
		} catch (InvalidMarksException e) { }
		
		
		//Use Case 2
		listMarks = Arrays.asList(78d,0.0,71d,45.0);
		try {
			actualResult = myService.computePercent(listMarks, totalmarks);
			double expectedResult = 48.5d;
			Assert.assertEquals(expectedResult,actualResult,0.001);
		} catch (InvalidMarksException e) { }
		
		
		//Use Case 3
		listMarks = Arrays.asList(78d);
		totalmarks = 90;
		try {
			actualResult = myService.computePercent(listMarks, totalmarks);
			double expectedResult = 86.66;
			Assert.assertEquals(expectedResult,actualResult,0.01);
		} catch (InvalidMarksException e) { }
		
		//use case 4
		listMarks = Arrays.asList(78d,67d,71d,-94.0);
		totalmarks = 400;
		try {
			actualResult = myService.computePercent(listMarks, totalmarks);
		} catch (InvalidMarksException e) {
			 Assert.assertEquals("Marks cannot be negative", e.getMessage());
		}
		
		//use case 5: alternative way using lambda in Junit 5
		 
		Exception exception = Assert.assertThrows(InvalidMarksException.class,
					()->myService.computePercent(Arrays.asList(78d,67d,71d,-94.0), 400)) ;
		 
		Assert.assertEquals("Marks cannot be negative", exception.getMessage());
		
		//use case 6: invalid  percent 
		Exception exception1 = Assert.assertThrows(InvalidMarksException.class,
				()->myService.computePercent(Arrays.asList(78d,67d,71d,94.0), 300)) ;
	 
		Assert.assertEquals("Percent cannot be > 100", exception1.getMessage());
	
	}
}







