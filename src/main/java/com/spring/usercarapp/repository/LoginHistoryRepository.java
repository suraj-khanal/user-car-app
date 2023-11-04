package com.spring.usercarapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.usercarapp.entity.LoginHistory;


public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Integer> {
	
	List<LoginHistory> findByUserSignupUsername(String username);
	

}
