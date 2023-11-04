package com.spring.usercarapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {
	
	@GetMapping("/logout")
	public String logoutUser(HttpSession session) {
		
		session.removeAttribute("userName");
		
		return "login";
	}
	
	
//	@GetMapping("/logout")
//	public String logoutUser(HttpSession session) {
//	    String username = (String) session.getAttribute("userName");
//
//	    if (username != null) {
//	        // Retrieve the user's login history list from the session
//	        List<UserLoginHistory> loginHistoryList = (List<UserLoginHistory>) session.getAttribute("loginHistory");
//
//	        // Update the logout time for the latest login history entry
//	        if (loginHistoryList != null && !loginHistoryList.isEmpty()) {
//	            UserLoginHistory latestLogin = loginHistoryList.get(loginHistoryList.size() - 1);
//	            latestLogin.setLogoutTime(new Timestamp(new Date().getTime()));
//	        }
//
//	        // Remove the userName and loginHistory attributes from the session
//	        session.removeAttribute("userName");
//	        session.removeAttribute("loginHistory");
//	    }
//
//	    return "login";
//	}

}
