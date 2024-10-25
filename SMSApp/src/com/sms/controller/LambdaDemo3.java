package com.sms.controller;

import java.util.List;

import com.sms.model.Instructor;
import com.sms.service.InstructorService;

public class LambdaDemo3 {
	public static void main(String[] args) {
		List<Instructor> list = new InstructorService().getAllInstructors();
		list.stream().forEach(i-> System.out.println(i));
		
		//map : reduces the list to a particular field
		/*Display all the names of Instructor 
		 * List<Instructor> : List<String> */
		
		List<String> listnames =  list.stream().map((i)->i.getName()).toList();
		System.out.println(listnames);
		
		List<Double> listSalary =  list.stream().map(Instructor :: getSalary).toList();
		System.out.println(listSalary);
		
		//filter: display instructors having salary > 80000 
		list = list.stream().filter(i->i.getSalary()>=80000).toList();
		System.out.println(list);
	}
}

/*
 * Consumer : forEach : needs any lambda 
 * Function : method/field name 
 * Predicate : true/false 
 */