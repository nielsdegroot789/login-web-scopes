package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.services.LoggedUserManagementService;

@Controller
public class MainController {

	private final LoggedUserManagementService loggedUserManagementService;
	
	public MainController(LoggedUserManagementService loggedUserManagementService) {
	this.loggedUserManagementService = loggedUserManagementService;
	}
	
	@GetMapping("/main")
	public String home(@RequestParam(required = false) String logout, Model model) {
		
		if(logout != null) {
			loggedUserManagementService.setUsername(null);
		}
		
		
		String username = loggedUserManagementService.getUsername();
		System.out.println(username);
		
		if(username == null) {
			return "redirect:/";
		} 
		
		model.addAttribute("username", username);
		
		System.out.println(username);
		
		return "main.html";
	}
	
}
