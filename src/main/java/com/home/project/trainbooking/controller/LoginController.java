package com.home.project.trainbooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/auth/showLoginPage")
	public String showLoginPage() {
		
		return "auth/log-in";
	}
}
