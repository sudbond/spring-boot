package com.mypackage.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "User1")
@Entity
public class User1 {
	@Id
	String username;
	String password;
	String role;

//Parameterized constructor
	public User1(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

//default constructor
	public User1() {

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
