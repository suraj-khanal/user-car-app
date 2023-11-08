package com.spring.usercarapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.usercarapp.entity.UserSignup;

public interface SignupRepository extends JpaRepository<UserSignup, Integer> {
	
	public Optional<UserSignup> findByUsernameAndPassword(String username, String password);
	
	public List<UserSignup> findByUsername(String username);
	
	 @Query("SELECT u FROM UserSignup u WHERE u.username = ?1")
	public Optional<UserSignup> findByUsernameOptional(String username);
	
}
