package com.javastack.spring.sneakabyte.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javastack.spring.sneakabyte.models.ShoeOptions;

@Repository
public interface ShoeOptionsRepository extends CrudRepository<ShoeOptions, Long> {

	 List<ShoeOptions> findAll();
	
//		Option<User> findByUserName(String userName);
}
