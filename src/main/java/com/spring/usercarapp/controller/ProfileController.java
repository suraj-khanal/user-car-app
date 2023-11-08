package com.spring.usercarapp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.spring.usercarapp.entity.UserSignup;
import com.spring.usercarapp.repository.SignupRepository;

@Controller
public class ProfileController {
	
	@Autowired
	private SignupRepository signupRepository;
	
	
	@GetMapping("/showUserInfo")
    public String showUserInfo(Model model,HttpSession session ) {
		
		String authenticatedUsername = (String) session.getAttribute("userName");
		
		if (authenticatedUsername != null) {
			
			List<UserSignup> userList = signupRepository.findByUsername(authenticatedUsername);

	        model.addAttribute("userdata", userList);

	        return "welcome";
		
        } 
		else {
        	
            model.addAttribute("error", "User not found");
            
            return "login";
        }
    }
}
