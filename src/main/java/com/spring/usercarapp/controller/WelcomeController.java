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
public class WelcomeController {
	
	@Autowired
	private SignupRepository signupRepository;


	@GetMapping("/showWelcome")
	public String showWelcomePage(HttpSession session, Model model) {
		
		String authenticatedUsername = (String) session.getAttribute("username");

		if (authenticatedUsername != null) {

			List<UserSignup> userList = signupRepository.findByUsername(authenticatedUsername);

			if (!userList.isEmpty()) {

				UserSignup user = userList.get(0);

				model.addAttribute("userData", user);

				return "welcome";

			}

			else {
				model.addAttribute("error", "User not found");
				return "login";
			}

		}

		return "login";

	}
}
