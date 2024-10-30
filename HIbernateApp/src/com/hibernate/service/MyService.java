package com.hibernate.service;

import java.util.List;
import java.util.stream.Collectors;

public class MyService {
	
	public double computePercent(List<Double> listMarks, 
			double totalMarks) {
		
		double totalMarksScored = listMarks.stream()
					.collect(Collectors.summingDouble(e->e));
		
		double percent = (totalMarksScored / totalMarks) * 100;
		return percent; 
	}
}
