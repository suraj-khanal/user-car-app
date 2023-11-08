package com.spring.usercarapp.controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.usercarapp.entity.LoginHistory;
import com.spring.usercarapp.repository.LoginHistoryRepository;

@Controller
public class LoginHistoryController {
	
	
	@Autowired
	private LoginHistoryRepository loginHistoryRepository;
	
	
	@GetMapping("/loginhistory/sortByDuration")
	public String sortLoginHistoryByDuration(String sortOrder, Model model, HttpSession session) {
		
		String username=(String)session.getAttribute("username");
		
		List<LoginHistory> loginHistoryList=loginHistoryRepository.findByUsername(username);
	
		if (sortOrder.equalsIgnoreCase("asc")) {
			
			Collections.sort(loginHistoryList,(h1,h2)->(int)(h1.getDurationInMillis()-h2.getDurationInMillis()));
			
		} else {
			
			Collections.sort(loginHistoryList,(h1,h2)->(int)(h2.getDurationInMillis()-h1.getDurationInMillis()));
	    
		}
		model.addAttribute("loginHistory",loginHistoryList);
		
		return "loginhistory";
	}
	
	@GetMapping("/showLoginHistory")
	public String showUserLoginHistory(HttpSession session, Model model) {
			
	    String username = (String) session.getAttribute("username");
	    

		if (username != null) {

			List<LoginHistory> loginHistoryList = loginHistoryRepository.findByUsername(username);

			if (!loginHistoryList.isEmpty()) {

				model.addAttribute("loginHistory", loginHistoryList);

				return "loginhistory";

			}

			else {
				model.addAttribute("error", "User Not Found");
				return "login";
			}

		}
		return "login";
	        	
	} 
	
	
	@GetMapping("/deleteLoginHistory")
	public String deleteLoginHistoryAction(@RequestParam Integer lhid) {
		
		loginHistoryRepository.deleteById(lhid);
		
		return "redirect:/showLoginHistory";
	}
	
}
