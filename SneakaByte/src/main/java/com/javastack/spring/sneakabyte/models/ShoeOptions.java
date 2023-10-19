package com.javastack.spring.sneakabyte.models;

import java.time.Year;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
	
		// Add optional Validation when necessary
	// shoe infos & add later when needed
	@NotEmpty(message="Name Required")
	@Size(min=3, max=15, message="Name must be between 3 - 15 characters")
	private String name;
	
	@NotNull(message = "Price is required")
	@DecimalMin(value = "0.01", message = "Price must be greater than or equal to 0.01")
	@DecimalMax(value = "50000.00", message = "Price must be less than or equal to 50000.00")
	private double price;


	@NotNull(message = "Price is required")
	@DecimalMin(value = "0.01", message = "Price must be greater than or equal to 0.01")
	@DecimalMax(value = "50000.00", message = "Price must be less than or equal to 50000.00")
	private double retailprice;
	
	@NotNull(message = "Release year is required")
	private Year releaseyear;
	
	@NotEmpty(message="Select color")
	@Size(min=2, max=15, message="Name must be between 2 - 15 characters")
	private String color;
	
	@NotEmpty(message="Please provide some info")
	private String description;
	
	
	// This has to match the mappedBy name from OnetoMany in order to connect
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	
	private User shoeCreator;
	
	public ShoeOptions() {
		
	}
	
	// Update the Constructor later

		//Getters & Setters
	public ShoeOptions(Long id, Date createdAt, Date updatedAt,
			@NotEmpty(message = "Name Required") @Size(min = 3, max = 15, message = "Name must be between 3 - 15 characters") String name,
			@NotNull(message = "Price is required") @DecimalMin(value = "0.01", message = "Price must be greater than or equal to 0.01") @DecimalMax(value = "50000.00", message = "Price must be less than or equal to 50000.00") double price,
			@NotNull(message = "Price is required") @DecimalMin(value = "0.01", message = "Price must be greater than or equal to 0.01") @DecimalMax(value = "50000.00", message = "Price must be less than or equal to 50000.00") double retailprice,
			@NotNull(message = "Release year is required") Year releaseyear,
			@NotEmpty(message = "Select color") @Size(min = 2, max = 15, message = "Name must be between 2 - 15 characters") String color,
			@NotEmpty(message = "Please provide some info") String description, User shoeCreator) {
		this.id = id;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.name = name;
		this.price = price;
		this.retailprice = retailprice;
		this.releaseyear = releaseyear;
		this.color = color;
		this.description = description;
		this.shoeCreator = shoeCreator;
		
		
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
	public Year getReleaseyear() {
		return releaseyear;
	}
	public void setReleaseyear(Year releaseyear) {
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
	public User getShoeCreator() {
		return shoeCreator;
	}
	public void setShoeCreator(User shoeCreator) {
		this.shoeCreator = shoeCreator;
	}

	

}
