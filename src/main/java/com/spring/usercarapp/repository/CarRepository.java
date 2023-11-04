package com.spring.usercarapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.usercarapp.entity.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {

	List<Car> findByUsername(String authenticatedUsername);

	
}
