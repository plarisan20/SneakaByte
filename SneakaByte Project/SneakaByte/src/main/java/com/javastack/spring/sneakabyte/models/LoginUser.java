package com.javastack.spring.sneakabyte.models;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

// No @Entity or @Table annotations- because we are not saving it to the DB
public class LoginUser {
	
	@NotEmpty(message="Please enter an email address")
	@Size(min=3, max=30, message="Email must be in proper format, such as *****@gmail.com")
	private String email;
	
	@NotEmpty(message="Password is required!")
	@Size(min=8, max=60, message="Password must be between 8 and 60 characters")
	@Column(columnDefinition="TEXT")
	private String password;
	
	public LoginUser() {}

	public LoginUser(
			@NotEmpty(message = "Please enter an email address") @Size(min = 3, max = 30, message = "Email must be in proper format, such as *****@gmail.com") String email,
			@NotEmpty(message = "Password is required!") @Size(min = 8, max = 60, message = "Password must be between 8 and 60 characters") String password) {
		this.email = email;
		this.password = password;
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
