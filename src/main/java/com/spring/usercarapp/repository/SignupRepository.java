package com.spring.usercarapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.usercarapp.entity.UserSignup;

public interface SignupRepository extends JpaRepository<UserSignup, Integer> {
	
	public Optional<UserSignup> findByUsernameAndPassword(String username, String password);
	
}
