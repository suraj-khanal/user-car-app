package com.spring.usercarapp.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.usercarapp.entity.LoginHistory;
import com.spring.usercarapp.repository.LoginHistoryRepository;

@Controller
public class LogoutController {
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
		
		historyEntity.setDurationInMillis(durationInMillis);
		
		historyEntity.setDuration(formattedDuration);
		
		loginHistoryRepository.save(historyEntity);
		
		session.invalidate();
		
		model.addAttribute("messageLogout","You have been logged out successfully.");
		
		return "login";
	}

}
