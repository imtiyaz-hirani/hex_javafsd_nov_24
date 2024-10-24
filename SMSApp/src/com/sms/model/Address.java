package com.sms.model;

public class Address {
	private int id;
	private String state;
	private String city;

	public Address(String city, String state) {
		 this.state = state;
		 this.city = city; 
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", state=" + state + ", city=" + city + "]";
	}

	
}
