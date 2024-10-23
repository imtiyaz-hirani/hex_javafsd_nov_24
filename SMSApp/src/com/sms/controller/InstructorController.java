package com.sms.controller;

import java.util.Scanner;

public class InstructorController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
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
					break;
				case 2: 
					break;
				case 3: 
					break;
				case 4:
					break;
				default:
					System.out.println("Invald Input, try again");
					break; 
				}
		}
		
		sc.close();
	}
}
