package com.sms.controller;
import java.util.List;
import java.util.Scanner;

import com.sms.exception.InvalidInputException;
import com.sms.exception.ResourceNotFoundException;
import com.sms.model.Instructor;
import com.sms.service.InstructorService;

public class InstructorController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		InstructorService instructorService = new InstructorService(sc);
		
		while(true) {
			System.out.println("=========Instructor Module===========");
			System.out.println("1. Add Instructor");
			System.out.println("2. Fetch all Instructors");
			System.out.println("3. Update Instructor record");
			System.out.println("4. Delete Instructor");
			System.out.println("5. Search by name");
			System.out.println("0. To Exit");
			System.out.println("======================================");
			int input = sc.nextInt();
			
			if(input ==0) {
				System.out.println("Exiting... Thank You!!");
				break;
			}
			
			switch(input) {
				case 1: 
					Instructor instructor =  instructorService.takeInput();
				try {
					instructorService.validate(instructor);
				} catch (InvalidInputException e) {
					 System.out.println(e.getMessage());
					 break;
				}
				instructorService.insert(instructor);
				System.out.println("Instructor record added in DB");
					break;
				case 2: 
					List<Instructor> list =  instructorService.getAllInstructors();
					System.out.println("**********All Instructors************");
					list.stream().forEach(i->{
						System.out.println(i.getId() + "--" + i.getName() + "--" + i.getJobTitle());
					});
					System.out.println("*************************************");
					break;
				case 3: 
					System.out.println("Enter the ID to update");
					int id = sc.nextInt();
					//validate id 
					try {
						instructor = instructorService.validateIdAndFetchRecord(id);
					} catch (ResourceNotFoundException e) {
						 System.out.println(e.getMessage());
						 break; 
					}
					
					System.out.println("Current values of Instructor with ID: "+ id);
					System.out.println(instructor.getId() + "--" 
									+ instructor.getName() + "--" 
									+ instructor.getJobTitle() + "--" 
									+ instructor.getContact());
					System.out.println("Enter new values to update");
					 Instructor i2 =  instructorService.takeInput(); //this i2 obj has all new values except id
					 //attach id to new obj i2
					 i2.setId(instructor.getId());
					 instructorService.update(i2);
					 System.out.println("Instructor record Updated...");
					break;
				case 4:
					System.out.println("Enter the ID to delete");
					id = sc.nextInt();
					//validate id 
				try {
					instructorService.validateId(id);
				} catch (ResourceNotFoundException e) {
					 System.out.println(e.getMessage());
					 break; 
				}
				 //delete instructor 
				instructorService.deleteById(id);
				System.out.println("Instructor record deleted...");
					break;
				default:
					System.out.println("Invald Input, try again");
					break; 
				}
		}
		
		sc.close();
	}
}
