package com.sms.utility;

import java.util.Comparator;

import com.sms.model.Instructor;

public class InstructorSortUtility implements Comparator<Instructor>{

	private String field; 
	private String direction;
	
	public InstructorSortUtility(String field, String direction) {
		super();
		this.field = field;
		this.direction = direction;
	}

	@Override
	public int compare(Instructor i1, Instructor i2) {
		if(field.equalsIgnoreCase("salary")) {
			if(direction.equalsIgnoreCase("ASC")) {
				return (int)(i1.getSalary() - i2.getSalary()); 
			}
			if(direction.equalsIgnoreCase("DESC")) {
				return (int)(i2.getSalary() - i1.getSalary()); 
			}
		}
		if(field.equalsIgnoreCase("name")) {
			if(direction.equalsIgnoreCase("ASC")) {
				return i1.getName().compareToIgnoreCase(i2.getName()); 
			}
			if(direction.equalsIgnoreCase("DESC")) {
				return i2.getName().compareToIgnoreCase(i1.getName()); 

			}
		}
		return 0;
	} 
	
	 
}
