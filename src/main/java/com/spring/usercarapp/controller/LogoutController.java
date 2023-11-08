package com.spring.usercarapp.controller;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
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
public class LogoutController {
	
	class SortByDuration implements Comparator<LoginHistory>{
		
		@Override
		public int compare(LoginHistory o1, LoginHistory o2) {
			
			return o1.getDuration().compareTo(o2.getDuration());
		}	
	}
	
	class SortByDurationDesc implements Comparator<LoginHistory>{
		
		@Override
		public int compare(LoginHistory o1, LoginHistory o2) {
			
			return o2.getDuration().compareTo(o1.getDuration());
		}	
	}
	
	@Autowired
	private LoginHistoryRepository loginHistoryRepository;
	
	LoginHistory loginHistory = new LoginHistory();
	
	
	@GetMapping("/logout")
	public String logout(Model model, HttpSession session){
		
		Integer dbid = (Integer) session.getAttribute("loginHistoryDbId");
		
		LoginHistory historyEntity= loginHistoryRepository.findById(dbid).get();
		
		historyEntity.setLogout_time(new Timestamp(new Date().getTime()));
		
		long durationInMillis = historyEntity.getLogout_time().getTime()-historyEntity.getLogin_time().getTime();
		
		String formattedDuration = loginHistory.formatDuration(durationInMillis);
		
		historyEntity.setDuration(formattedDuration);
		
		loginHistoryRepository.save(historyEntity);
		
		session.invalidate();
		
		model.addAttribute("messageLogout","You have been logged out successfully.");
		
		return "login";
	}
	
	@GetMapping("/deleteLoginHistory")
	public String deleteLoginHistoryAction(@RequestParam Integer lhid) {
		
		loginHistoryRepository.deleteById(lhid);
		
		return "redirect:/showLoginHistory";
	}
	
	@GetMapping("/sortByDuration")
	public String sortLoginHistoryByDuration(@RequestParam String sortname, Model model) {
		
		
		List <LoginHistory> loginHistoryList= loginHistoryRepository.findAllByDurationIsNotNull();
		
		if (sortname.equalsIgnoreCase("asc")) {
			
			model.addAttribute("sortname", "desc");
			Collections.sort(loginHistoryList, new SortByDurationDesc());
			
		} else {
			
			model.addAttribute("sortname", "asc");
			Collections.sort(loginHistoryList, new SortByDuration());
	    
		}
			
		return "loginhistory";
	}

}
