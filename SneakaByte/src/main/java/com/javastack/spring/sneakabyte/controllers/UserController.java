package com.javastack.spring.sneakabyte.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.javastack.spring.sneakabyte.models.LoginUser;
import com.javastack.spring.sneakabyte.models.User;
import com.javastack.spring.sneakabyte.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	@Autowired
	private UserService userServ;
	
	// This return's the JSP WebPage, so this is the Base
	@GetMapping("/")
	public String webPage() {
		return "webpage.jsp";
	}
	
	// when the hyperlink is clicked, it would go straight to the reg/log in page
	@GetMapping("/register") // Display the login/registration page
	public String regPage(@ModelAttribute("registerUser") User registerUser) {
		return "registration.jsp";
	}

	
	// IF THE USER IS REGISTERED TO THE DB
	@PostMapping("/register") // Handle registration from form
	public String processRegistration(@Valid @ModelAttribute("registerUser") 
		User newUser, BindingResult result,
		@ModelAttribute("loginUser")LoginUser loginUser, HttpSession session) {
		User newAccount = userServ.register(newUser, result);
		if(result.hasErrors()) {
			return "registration.jsp";
		} else {
			// this woudld Register the user in the DB
			// Save the ID of the logged in user in session
			session.setAttribute("userId", newAccount.getId());
			return "redirect:/homepage";		
		}
	}
	
	// User Log in Get Mapping if user already has an Account
	@GetMapping("/login") // Display the login/registration page
	public String loginPage(@ModelAttribute("loginUser") LoginUser loginUser) {
		return "login.jsp";
	}
	
	// IF THE USER IS SAVED TO THE DB
	@PostMapping("/login") // Handle the login form
	public String processLogin(@Valid @ModelAttribute("loginUser") LoginUser loginUser,
			BindingResult result, Model model,
			HttpSession session) {
		
		//perform the validation, and get the User if the credentials are correct
		User foundUser= userServ.login(loginUser, result);
		if (result.hasErrors()) { // if the validation is incorrect
			model.addAttribute("registerUser", new User());
			return "login.jsp"; 
		} else {
			// if everything is good
			session.setAttribute("userId", foundUser.getId());
			return "redirect:/homepage";
			
			
		}
	}
	

	// Logging out from the app  
	@GetMapping("/logout")  
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
