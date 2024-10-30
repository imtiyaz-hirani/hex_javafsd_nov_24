package com.hibernate.service;

import java.util.List;
import java.util.stream.Collectors;

import com.hibernate.exception.InvalidMarksException;

public class MyService {
	
	public double computePercent(List<Double> listMarks, 
			double totalMarks) throws InvalidMarksException{
		
		for(double m : listMarks) {
			if(m<0)
				throw new InvalidMarksException("Marks cannot be negative");
		}
		
		double totalMarksScored = listMarks.stream()
					.collect(Collectors.summingDouble(e->e));
		
		double percent = (totalMarksScored / totalMarks) * 100;
		
		if(percent>100)
			throw new InvalidMarksException("Percent cannot be > 100");
		
		return percent; 
	}
}
/*
 * Product(id,title,price)
 * list.stream().collect(Collectors.summingDouble(p->p))
 * Collectors 
 * 		summingDouble / summingInt/ summingLong 
 * 
 *  - the marks of each subject must no be negative. 
 *  - the overall percent cannot be more than 100. 
 * 
 */