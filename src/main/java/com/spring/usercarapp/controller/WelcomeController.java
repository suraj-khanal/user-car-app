package com.spring.usercarapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	
	@GetMapping("/showWelcome")
	public String showWelcomePage() {
		
		return "welcome";
	}
}
