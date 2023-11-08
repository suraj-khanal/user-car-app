package com.spring.usercarapp.controller;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.usercarapp.entity.UserSignup;
import com.spring.usercarapp.repository.SignupRepository;

@Controller
public class SignupController {
	
	@Autowired
	private SignupRepository signupRepository;
	
	@GetMapping("/showSignup")
	public String showSignupPage () {
		
		
		return "signup";
	}
	
	@PostMapping("/addSignup")
	public String postSignup(@ModelAttribute UserSignup userSignup) {
		userSignup.setDoe(new Timestamp(new Date().getTime()));
		signupRepository.save(userSignup);
		return "login";
	}
	
	
}
