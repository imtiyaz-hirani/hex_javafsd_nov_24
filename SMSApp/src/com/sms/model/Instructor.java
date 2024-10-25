package com.sms.model;

public class Instructor implements Comparable<Instructor>{
	private int id;
	private String name;
	private double salary;
	private String contact;
	private String jobTitle;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	 

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", name=" + name + ", salary=" + salary + ", contact=" + contact + ", jobTitle="
				+ jobTitle + "]";
	}

	@Override
	public int compareTo(Instructor i2) {
		 //what is my criteria for sorting? salary 
		/*
		 * i1(24)   i2(20) : ASC   [swap] :-  [i2,i1]
		 * i1(20)   i2(24) : ASC   [ignore] :-  [i1,i2]
		 * i1(24)   i2(24) : ASC   [ignore] :-  [i1,i2]
		 * */
		//if(this.salary > i2.salary) {/*swap*/ return 1; } //use this for i1 
		//if(this.salary < i2.salary) {/*ignore*/ return -1; }
		//if(this.salary == i2.salary) {/*ignore*/ return 0; }
		
		return (int)(this.salary - i2.salary);
	}

	
}
//ctrl+shft+f