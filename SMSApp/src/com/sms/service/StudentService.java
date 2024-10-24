package com.sms.service;

import java.sql.Connection;
import java.util.Random;
import java.util.Scanner;

import com.sms.model.Address;
import com.sms.model.Student;
import com.sms.model.User;
import com.sms.repository.StudentRepository;
import com.sms.utility.DbConnection;

public class StudentService {

	private Scanner sc;
	private StudentRepository studentRepository = new StudentRepository(); 
	
	public StudentService(Scanner sc) {
		 this.sc = sc; 
	}

	public Student takeInput() {
		System.out.println("Enter name");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.println("Enter contact");
		String contact = sc.nextLine();
		System.out.println("---Enter User Info------");
		System.out.println("Enter Username:");
		String username = sc.nextLine();
		System.out.println("Enter Password:");
		String password = sc.nextLine();
		System.out.println("---Enter Address Info------");
		System.out.println("Enter City: ");
		String city = sc.nextLine();
		System.out.println("Enter State: ");
		String state = sc.nextLine();
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setRole("STUDENT");
		
		Address address = new Address(city,state);
		
		Student student = new Student(); 
		student.setName(name);
		student.setContact(contact);
		student.setUser(user);
		student.setAddress(address);
		
		return student;
	}

	public void insert(Student student) {
		Connection conn =  DbConnection.dbConnect();
		//create user id
		 
		int userId = (int) (Math.random()*10000000);
		User user = student.getUser(); 
		user.setId(userId);
		student.setUser(user);
		studentRepository.insertUser(user, conn); 
		//create address id
		int addressId = (int) (Math.random()*10000000);
		 Address address  = student.getAddress(); 
		 address.setId(addressId);
		 student.setAddress(address);
		 
		studentRepository.insertAddress(address,conn);
		//create student id
		int studentId = (int) (Math.random()*100000000);
		student.setId(studentId);
		studentRepository.insertStudent(student,conn);
		DbConnection.dbClose();
		
	}

}
