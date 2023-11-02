package com.spring.skyy.springskyy;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.skyy.springskyy.dog.Dog;


public interface DogRepository extends JpaRepository<Dog, String> {

	
}
