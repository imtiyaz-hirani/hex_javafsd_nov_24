package com.sms.exception;

public class ResourceNotFoundException extends Exception{

	private static final long serialVersionUID = -1758914556059277278L;
	
	private String message;
	//constructor
	public ResourceNotFoundException(String message) {
		super();
		this.message = message;
	}
	//getter
	public String getMessage() {
		return message;
	} 
	
}