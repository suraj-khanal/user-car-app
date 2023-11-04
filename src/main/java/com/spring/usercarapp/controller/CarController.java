package com.spring.usercarapp.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.usercarapp.entity.Car;
import com.spring.usercarapp.repository.CarRepository;



@Controller
public class CarController {
	
	@Autowired
	private CarRepository carRepository;
	
	@PostMapping("/addCar")
	public String postCar(@ModelAttribute Car car, HttpSession session) {
		
		String authenticatedUsername = (String) session.getAttribute("userName");
		
		if (authenticatedUsername != null) {
			
	        car.setUsername(authenticatedUsername);
	        car.setDoe(new Timestamp(new Date().getTime()));
	        
	        carRepository.save(car);
	        
	        return "redirect:show-cars";
	        
	    } else {
	        
	        return "login"; 
	    }
	}
	
	@GetMapping("/show-cars")
	public String showDogs(Model model,HttpSession session ) {
		
		String authenticatedUsername = (String) session.getAttribute("userName");
		 
		  if (authenticatedUsername != null) {
		        
		        List<Car> carList = carRepository.findByUsername(authenticatedUsername);

	
		        model.addAttribute("cardata", carList);

		        return "carDetails";
		        
		    } else {
		    	
		        return "login";
		    }
	}
	
	@GetMapping("deleteCar")
	public String deleteCarAction(@RequestParam Integer carId) {
		
		carRepository.deleteById(carId);
		
		return "redirect:/show-cars";
	}
	

	
	
}
