package com.javastack.spring.sneakabyte.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javastack.spring.sneakabyte.models.ShoeOptions;
import com.javastack.spring.sneakabyte.repositories.ShoeOptionsRepository;

@Service
public class ShoeService {
	@Autowired
	private ShoeOptionsRepository shoeoptionsRepo;

	
	// CREATE
	public ShoeOptions createShoe(ShoeOptions newshoeoptions) {
		return shoeoptionsRepo.save(newshoeoptions);
	}
	
	
	// READ
	public List<ShoeOptions> getAllShoeOptions() {
		return shoeoptionsRepo.findAll();
	}
	
	
	// READ by ID
	public ShoeOptions getByIdShoeCreator(Long id) {
		Optional<ShoeOptions> possibleShoeCreator = shoeoptionsRepo.findById(id);
	return possibleShoeCreator.isPresent() ? possibleShoeCreator.get() : null;
	// if the possibleShoeCreator(id) exist! : then get that specific ID: else, return null
	}

		
	// UPDATE
	public ShoeOptions updateShoeOptions(ShoeOptions updatedShoeOptions) {
		return shoeoptionsRepo.save(updatedShoeOptions);
		// Implement the logic to update an existing shoe in the database
	}
		
		
	// DELETE 
	public void deleteShoeOptions(Long id) {
		shoeoptionsRepo.deleteById(id);
		// Implement the logic to delete a book by its ID from the database
	}
	
	

}
	
	
	
