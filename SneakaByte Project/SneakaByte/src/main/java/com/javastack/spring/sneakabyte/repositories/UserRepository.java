package com.javastack.spring.sneakabyte.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javastack.spring.sneakabyte.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

//	List<User> findAll();
	
	Optional<User> findByEmail(String email); // Search the email into the DB
	
}
