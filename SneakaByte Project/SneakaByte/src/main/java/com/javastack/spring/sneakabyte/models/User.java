package com.javastack.spring.sneakabyte.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// This will not allow the createdAt column to be updated after creation
		@Column(updatable=false)
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private Date createdAt;
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private Date updatedAt;

	// other getters and setters removed for brevity
	// use in order to create/update the time of the data
		@PrePersist
		protected void onCreate(){
	       	this.createdAt = new Date();
	       	this.updatedAt = new Date();
	}
		@PreUpdate
		protected void onUpdate(){
			this.updatedAt = new Date();
	}
		
		@NotEmpty(message="Please enter a user name")
    	@Size(min=3, max=30, message="Username must be between 3 and 30 characters")
    	private String userName;
		
		@NotEmpty(message="Please enter an email address")
    	@Size(min=3, max=30, message="Email must be in proper format, such as *****@gmail.com")
    	private String email;
		
		@NotEmpty(message="Password is required!")
    	@Size(min=8, max=60, message="Password must be between 8 and 60 characters")
    	@Column(columnDefinition="TEXT")
		private String password;
		
		@Transient // this Do not save to the Database
		@NotEmpty(message="Please enter your confirmed password")
		@Size(min=8, max=60, message="Password must match")
		private String confirmedPassword;

		
		
		public User() {}
		
		public User(
				@NotEmpty(message = "Please enter a user name") @Size(min = 3, max = 30, message = "Username must be between 3 and 30 characters") String userName,
				@NotEmpty(message = "Please enter an email address") @Size(min = 3, max = 30, message = "Email must be in proper format, such as *****@gmail.com") String email,
				@NotEmpty(message = "Password is required!") @Size(min = 8, max = 60, message = "Password must be between 8 and 60 characters") String password,
				@NotEmpty(message = "Please enter your confirmed password") @Size(min = 8, max = 60, message = "Password must match") String confirmedPassword) {
			this.userName = userName;
			this.email = email;
			this.password = password;
			this.confirmedPassword = confirmedPassword;
		}
		// get your Getters/Setters
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Date getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}
		public Date getUpdatedAt() {
			return updatedAt;
		}
		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
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
		public String getConfirmedPassword() {
			return confirmedPassword;
		}
		public void setConfirmedPassword(String confirmedPassword) {
			this.confirmedPassword = confirmedPassword;
		}
		
			
}
