package com.javastack.spring.sneakabyte.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.javastack.spring.sneakabyte.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ShoeOptionsController {
	@Autowired
	private UserService userServ;

	@GetMapping("/homepage") // Landing page after register login
	public String dashboard(HttpSession session, Model viewModel) {
		// if nothing in session it would send directly to the main page /
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		Long userID = (Long) session.getAttribute("userId");
		// send a message to the service to grab the user on the saved ID in session, then save in in the model
		viewModel.addAttribute("loggedUser", userServ.findById(userID));
		return "homepage.jsp";
	}

}
