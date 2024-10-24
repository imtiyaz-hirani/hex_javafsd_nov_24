package com.sms.controller;

import java.util.List;
import java.util.Scanner;

import com.sms.dto.StudentDto;
import com.sms.model.Student;
import com.sms.service.StudentService;

public class StudentController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentService studentService = new StudentService(sc);
		while(true) {
			System.out.println("=========Student Module===========");
			System.out.println("1. Add Student");
			System.out.println("2. Fetch Student Info");
			System.out.println("0. To Exit");
			System.out.println("======================================");
			int input = sc.nextInt();
			
			if(input ==0) {
				System.out.println("Exiting... Thank You!!");
				break;
			}
			switch(input) {
			case 1: 
				Student student = studentService.takeInput();
				//validate fields 
				//insert user, address,student 
				studentService.insert(student); 
				System.out.println("Student along with User and Address details added to DB");
				break; 
			case 2: 
				List<StudentDto> list =  studentService.getAllStudentsInfo();
				list.stream().forEach(e-> System.out.println(e));
				break; 
			default: 
				System.out.println("Invald Input, try again");
				break; 
			}
		}
		sc.close();
	}
}
