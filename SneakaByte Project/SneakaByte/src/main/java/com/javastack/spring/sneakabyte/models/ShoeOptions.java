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
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="shoeoptions")
public class ShoeOptions {
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
	
	// shoe infos & add later when needed
	@NotEmpty(message="Name Required")
	@Size(min=3, max=15, message="Name must be between 3 - 15 characters")
	private String name;
	
	// add an error message on numbers later on
	private double price;
	// add an error message on numbers later on
	private double retailprice;
	
	// Double check how date info works
	private String releaseyear;
	
	@NotEmpty(message="Select color")
	@Size(min=2, max=15, message="Name must be between 2 - 15 characters")
	private String color;
	
	@NotEmpty(message="Please provide some info")
	private String description;

	
	// Update the Constructor later
	public ShoeOptions(Long id, Date createdAt, Date updatedAt,
			@NotEmpty(message = "Name Required") @Size(min = 3, max = 15, message = "Name must be between 3 - 15 characters") String name,
			double price, double retailprice, String releaseyear,
			@NotEmpty(message = "Select color") @Size(min = 2, max = 15, message = "Name must be between 2 - 15 characters") String color,
			@NotEmpty(message = "Please provide some info") String description) {
		this.id = id;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.name = name;
		this.price = price;
		this.retailprice = retailprice;
		this.releaseyear = releaseyear;
		this.color = color;
		this.description = description;
		
		//Getters & Setters
	}
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getRetailprice() {
		return retailprice;
	}
	public void setRetailprice(double retailprice) {
		this.retailprice = retailprice;
	}
	public String getReleaseyear() {
		return releaseyear;
	}
	public void setReleaseyear(String releaseyear) {
		this.releaseyear = releaseyear;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	
	
		
		
}
