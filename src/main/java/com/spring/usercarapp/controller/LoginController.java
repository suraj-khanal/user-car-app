package com.spring.usercarapp.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.usercarapp.entity.LoginHistory;
import com.spring.usercarapp.entity.UserSignup;
import com.spring.usercarapp.repository.LoginHistoryRepository;
import com.spring.usercarapp.repository.SignupRepository;

@Controller
public class LoginController {
	
	@Autowired
	private SignupRepository signupRepository;
	
	@Autowired
	private LoginHistoryRepository loginHistoryRepository;
	
	@GetMapping({"/login","/"})
	public String showLoginPage() {
		
		return "login";
	}
	
	
	@PostMapping("/auth")
	public String validateUser(@ModelAttribute UserSignup userSignup ,HttpSession session, Model model) {
		
		Optional<UserSignup> optional = signupRepository.findByUsernameAndPassword(userSignup.getUsername(), userSignup.getPassword());
		if(optional.isPresent()) {
			
			UserSignup dbSignup = optional.get();
			LoginHistory loginHistory = new LoginHistory();
			loginHistory.setLogin_time(new Timestamp(new Date().getTime()));
			
			loginHistory.setUserSignup(dbSignup);
			LoginHistory dbEntity = loginHistoryRepository.save(loginHistory);
			
			//This line sets the max interval on session
			//session.setMaxInactiveInterval(30);

			session.setAttribute("username", userSignup.getUsername());
			session.setAttribute("loginHistoryDbId", dbEntity.getLhid());
			
			
			return "redirect:/showWelcome";
			
		}else {
			
			model.addAttribute("loginErrMsg", "Invalid Username or Password!");
			return "login";
		}
		
	}

	
}
