package com.mypackage.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//The @Entity annotation specifies that the 
//class is an entity and is mapped to a database table. 
//The @Table annotation specifies the name of 
//the database table to be used for mapping
@Entity
@Table(name = "myuser")
public class MyUser {
	@Id
	String username;
	String password;
	String dob;
	String gender;

	
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
