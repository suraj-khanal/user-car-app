package com.spring.skyy.springskyy.dog;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.skyy.springskyy.DogRepository;

class SortByName implements Comparator<Dog>{
	
	@Override
	public int compare(Dog o1, Dog o2) {
		
		return o1.getName().compareTo(o2.getName());
	}	
}

class SortByNameDesc implements Comparator<Dog>{
	
	@Override
	public int compare(Dog o1, Dog o2) {
		
		return o2.getName().compareTo(o1.getName());
	}	
}

@Controller
public class DogController {
	
	@Autowired
	private DogRepository dogRepository;
	
	//Comparators using lambda expression
    private Comparator<Dog> sortByColor = (o1, o2) -> o1.getColor().compareTo(o2.getColor());
    private Comparator<Dog> sortByColorDesc = (o1, o2) -> o2.getColor().compareTo(o1.getColor());
	
	
	@GetMapping({ "/", "/dog" })
	public String showPage() {
		
		return "dog"; 
	}

	@PostMapping("/addDog")
	public String postData(HttpServletRequest req) {
		String name = req.getParameter("name");
		String color = req.getParameter("color");
		String breed = req.getParameter("breed");
		String url = req.getParameter("url");
		
		Timestamp currentDate = new Timestamp(System.currentTimeMillis());

		Dog dog = new Dog(name, color, breed, url);
		dog.setCdate(currentDate);
		
		dogRepository.save(dog);

		req.setAttribute("tictick", dog);
		return "redirect:/show-dogs";
	}
	
	@GetMapping("/sortByName")
	public String sortDogsByName(@RequestParam String sortname, Model model) {
		
		List <Dog> dogList= dogRepository.findAll();
		
		if (sortname.equalsIgnoreCase("asc")) {
			
			model.addAttribute("sortname", "desc");
			Collections.sort(dogList, new SortByNameDesc());
			
		} else {
			
			model.addAttribute("sortname", "asc");
			Collections.sort(dogList, new SortByName());
		}
		
		model.addAttribute("dogdata", dogList);	
		return "showDog";
	}
	
	@GetMapping("/sortByColor")
	public String sortDogsByColor(@RequestParam String sortname, Model model) {
		
		List <Dog> dogList= dogRepository.findAll();
		
		if (sortname.equalsIgnoreCase("asc")) {
			
			model.addAttribute("sortname", "desc");
			Collections.sort(dogList, sortByColorDesc);
			
		} else {
			
			model.addAttribute("sortname", "asc");
			Collections.sort(dogList, sortByColor);
		}
		
		model.addAttribute("dogdata", dogList);	
		return "showDog";
	}

	@GetMapping("/show-dogs")
	public String showDogs(Model model) {
		
		List <Dog> dogList= dogRepository.findAll();
		
		Collections.sort(dogList, new SortByName());
		
		model.addAttribute("sortname", "asc");
		
		model.addAttribute("dogdata", dogList);	
		return "showDog"; 
	}

	@GetMapping("deleteDog")
	public String deleteDogAction(@RequestParam String dogname) {
		
		dogRepository.deleteById(dogname);
		
		return "redirect:/show-dogs";
	}
	


	
//	@GetMapping("/editDog")
//	public String editDogForm(@RequestParam String dogname, Model model) {
//	    // Retrieve the dog's information by name
//	    String sql = "select name, color, breed, photo as url from dogs_tbl where name = ?";
//	    Dog dog = jdbcTemplate.queryForObject(sql, new Object[] { dogname }, new BeanPropertyRowMapper<>(Dog.class));
//
//	    model.addAttribute("dog", dog);
//
//	    return "editDogForm"; // Create an edit form view (e.g., editDogForm.jsp) to edit the dog's details
//	}
//	
//	@PostMapping("/updateDog")
//	public String updateDog(@ModelAttribute Dog updatedDog, @RequestParam("originalName") String originalName) {
//	    // Update the dog's information in the database
//	    String sql = "UPDATE dogs_tbl SET name = ?, color = ?, breed = ?, photo = ? WHERE name = ?";
//	    jdbcTemplate.update(sql, updatedDog.getName(), updatedDog.getColor(), updatedDog.getBreed(), updatedDog.getUrl(), originalName);
//
//	    return "redirect:/show-dogs";
//	}
//	
//	
//	//To edit the image of a particular Dog
//	
//	@GetMapping("/editDogImage")
//	public String editDogImage(@RequestParam String dogname, Model model) {
//	    // Retrieve the dog's information by name
//	    String sql = "select name, color, breed, photo as url from dogs_tbl where name = ?";
//	    Dog dog = jdbcTemplate.queryForObject(sql, new Object[] { dogname }, new BeanPropertyRowMapper<>(Dog.class));
//
//	    model.addAttribute("dog", dog);
//
//	    return "editDogForm"; // Create an edit form view (e.g., editDogForm.jsp) to edit the dog's details
//	}



}