package com.javastack.spring.sneakabyte.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.javastack.spring.sneakabyte.models.LoginUser;
import com.javastack.spring.sneakabyte.models.User;
import com.javastack.spring.sneakabyte.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	// TO-DO: Write register and login methods! Register if the validation succeed
	public User register(User newUser, BindingResult result) {
		// check if the password match
		if (!newUser.getPassword().equals(newUser.getConfirmedPassword())) {
			result.rejectValue("password","passwordsDisagree.registerUser.password" , "Password must match");
		}
		// check to see if the same email is already in the database
		Optional<User> foundUser = userRepo.findByEmail(newUser.getEmail());
		if (foundUser.isPresent()) {
			result.rejectValue("email", "emailTaken.registerUser.email", "Email already taken");
		}
		if(result.hasErrors()) { 
			return null;
		} else {
			// hashed password
			String hashedPassword = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(hashedPassword); // save the hashpassword before it goes to the database
			return userRepo.save(newUser);
		}
	}
	
	public User findById(Long id) {
		Optional<User> foundUser = userRepo.findById(id);
		return foundUser.isPresent()? foundUser.get() : null;
		// find if there is a User under that ID.. grab it, if not return nothing
	}
	
	public User login(LoginUser newLoginAccount, BindingResult result) {
		Optional<User> foundUser = userRepo.findByEmail(newLoginAccount.getEmail());
		if (foundUser.isEmpty()) {
			result.rejectValue("email", "invalidCredentials.loginUser.email", "Invalid login credentials");
			return null;
		} else { // Find User
			User userFromDB = foundUser.get();
			// Check the password
			if(!BCrypt.checkpw(newLoginAccount.getPassword(), userFromDB.getPassword())) {
			    result.rejectValue("email", "invalidCredentials.loginUser.email", "Invalid login credentials");
			    return null;
		} else { //
			return userFromDB;
		}
		}
	}
}
