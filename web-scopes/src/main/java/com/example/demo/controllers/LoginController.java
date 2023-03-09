package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.processors.LoginProcessor;

import ch.qos.logback.core.model.Model;

@Controller 
public class LoginController {

	private final LoginProcessor loginProcessor;
	
	@Autowired
	public LoginController(LoginProcessor loginProcessor) {
		this.loginProcessor = loginProcessor;
	}
	
	@GetMapping("/")
	public String loginGet() {
		return "login.html";
	}
	
	@PostMapping("/") 
	public String loginPost(@RequestParam String username, @RequestParam String password, org.springframework.ui.Model page) {
		boolean loggedIn = false;
		
		loginProcessor.setUsername(username);
		loginProcessor.setPassword(password);
		
		loggedIn = loginProcessor.login();
		
		if(loggedIn) {
			return  "redirect:/main";
		} else {
			page.addAttribute("message", "Login failed");
		}
		
		return "login.html";
	}
	
}
