package com.home.project.trainbooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {
	
	@GetMapping(path = {"/", "index"})
	public String showIndexForm() {
		return "index";
	}

}
