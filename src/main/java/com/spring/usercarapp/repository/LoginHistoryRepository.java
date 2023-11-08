package com.spring.usercarapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.usercarapp.entity.LoginHistory;


public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Integer> {
	
	List<LoginHistory> findByUserSignupUsername(String username);
	
	//HQL - >> Since we are writing it  on the basis of 
	//class name and attribute of instead of using table name and column of it
	@Query("from LoginHistory le where le.userSignup.username = ?1")
	public List<LoginHistory> findByUsername(String username);
	
	 List<LoginHistory> findAllByDurationIsNotNull();
	

}
