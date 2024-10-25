package com.designpatterns.singleton;

public class EmailUtilityAzure extends EmailUtility{
	
	static EmailUtilityAzure emailUtilityAzure;
	
	static {
		emailUtilityAzure = new EmailUtilityAzure();
	}
	private EmailUtilityAzure(){
		super("");
		
	}
	
	public static EmailUtilityAzure getInstance(){
		return emailUtilityAzure; 
	}
	
	public void sendMail() {
		System.out.println("connection details of server 2");
		System.out.println("Mail send with following info");
		System.out.println("From Email: " + fromEmail);
		System.out.println("To Email: " + toEmail);
		System.out.println("Subject: " + subject);
		System.out.println("Email Body: " + content);
	}
}
