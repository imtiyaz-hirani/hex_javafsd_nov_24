package com.sms.controller;

import java.util.Collections;
import java.util.List;

import com.sms.model.Instructor;
import com.sms.service.InstructorService;

public class SortingObjDemo {
	public static void main(String[] args) {
		 InstructorService instructorService = new InstructorService();
		 List<Instructor> list = instructorService.getAllInstructors();
		 list.stream().forEach(System.out :: println); 
		 
		 Collections.sort(list);
		 System.out.println("--------After sorting----------");
		 list.stream().forEach(System.out :: println); 
	}
}
/*
 * Collections.sort(list) : Integer/String
 * Collections.sort(listProduct) : Product -- does not work 
 * 
 * Integer/String are doing something that we are not doing in our model classes 
 * 
 * Your Model class, must implement Comparable interface. 
 * 
 * now you need to override/implement method of Comparable interface 
 * 
 * compareTo()
 * 
 * Quick Sort : double pivot technique 
 */