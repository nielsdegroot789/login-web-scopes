package com.example.demo.processors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.RequestScope;

import com.example.demo.services.LoggedUserManagementService;

@Component
@RequestScope
public class LoginProcessor {

	private String username;
	private String password;
	
	private final LoggedUserManagementService loggedUserManagementService;
	
	@Autowired
	public LoginProcessor(LoggedUserManagementService loggedUserManagementService) {
		this.loggedUserManagementService = loggedUserManagementService;
	}
	
	
	public boolean login() {
		
		if("patrick".equals(username) && "123".equals(password)) {
			loggedUserManagementService.setUsername(username);
			return true;
		} else {
			return false;
		}
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
