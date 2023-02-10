package com.mypackage.Service;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class User {
	@NotEmpty
	@Pattern(regexp = "[a-zA-Z]{3,}", message = "Name must contain at least 3 char and must be alphabet")
	String first;
	@NotEmpty
	@Pattern(regexp = "[a-zA-Z]{3,}", message = "Name must contain at least 3 char and must be alphabet")
	String last;
	@Email
	String email;
	@Pattern(regexp = "[0-9]{10}", message = "Phone Number must be of 10 Digit")
	String phone;

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
