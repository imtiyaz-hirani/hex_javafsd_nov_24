package com.hibernate.model;

import com.hibernate.enums.RoleType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_info")
public class User { 

	@Id
	private int id;
	
	@Column(unique = true)
	private String username;
	private String password;
	
	@Enumerated(EnumType.STRING)
	private RoleType role;
	
	private boolean isPasswordReset; 
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RoleType getRole() {
		return role;
	}

	public void setRole(RoleType role) {
		this.role = role;
	}

	public boolean isPasswordReset() {
		return isPasswordReset;
	}

	public void setPasswordReset(boolean isPasswordReset) {
		this.isPasswordReset = isPasswordReset;
	} 
	 
	
}
