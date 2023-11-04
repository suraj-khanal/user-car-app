package com.spring.usercarapp.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
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
	
	@GetMapping("/login")
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
			loginHistoryRepository.save(loginHistory);
	
			
			String username = userSignup.getUsername();
			model.addAttribute("welcomeMsg", username);	
			session.setAttribute("userName", username);
			return "welcome";	
		}else {
			model.addAttribute("loginErrMsg", "Invalid Username or Password!");
			return "login";
		}
		
	}
	
	@GetMapping("/showLoginHistory")
	public String showUserLoginHistory(HttpSession session, Model model) {
			
	    String username = (String) session.getAttribute("userName");

	    if (username != null) {
	       
	        List<LoginHistory> loginHistoryList = loginHistoryRepository.findByUserSignupUsername(username);

	        model.addAttribute("loginHistory", loginHistoryList);
	        
	        return "loginhistory";
	    } else {
	        
	        model.addAttribute("loginErrMsg", "User not found in the session.");
	        return "login"; 
	    }
			
	} 
		

	
}
