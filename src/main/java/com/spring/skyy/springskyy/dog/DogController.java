package com.spring.skyy.springskyy.dog;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DogController {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping({ "/", "/dog" })
	public String showPage() {
		/// dog.jsp
		return "dog"; /// Here spring will add prefix and suffix /dog.jsp
	}

	// <form action="addDog" method="post">
	@PostMapping("/addDog")
	public String postData(HttpServletRequest req) {
		String name = req.getParameter("name");
		String color = req.getParameter("color");
		String breed = req.getParameter("breed");
		String url = req.getParameter("url");

		// Save data inside the database
		Object[] data = new Object[] { name, color, breed, new Timestamp(new Date().getTime()), url };
		jdbcTemplate.update("insert into dogs_tbl values(?, ?, ?, ?, ?)", data);

		Dog dog = new Dog(name, color, breed, url);
		// dog object adding into request scope
		req.setAttribute("tictick", dog);
		return "redirect:/show-dogs";
	}

	@GetMapping("/show-dogs")
	public String showDogs(Model model) {

		String sql = "select name, color, breed, photo as url, cdate from dogs_tbl";

		List<Dog> dogList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Dog.class));

		model.addAttribute("dogdata", dogList);

		return "showDog"; /// Here spring will add prefix and suffix /showDog.jsp
	}

	@GetMapping("deleteDog")
	public String deleteDogAction(@RequestParam String dogname) {

		String sql = "delete from dogs_tbl where name = ?";

		jdbcTemplate.update(sql, new Object[] { dogname });

		return "redirect:/show-dogs";
	}
	
	@GetMapping("/sortByName")
	public String sortDogsByName(Model model) {
	    String sql = "SELECT name, color, breed, photo AS url, cdate FROM dogs_tbl ORDER BY name ASC";
	    List<Dog> dogList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Dog.class));
	    model.addAttribute("dogdata", dogList);
	    return "showDog";
	}

	@GetMapping("/sortByColor")
	public String sortDogsByColor(Model model) {
	    String sql = "SELECT name, color, breed, photo AS url, cdate FROM dogs_tbl ORDER BY color ASC";
	    List<Dog> dogList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Dog.class));
	    model.addAttribute("dogdata", dogList);
	    return "showDog";
	}
	
	@GetMapping("/sortByBreed")
	public String sortDogsByBreed(Model model) {
	    String sql = "SELECT name, color, breed, photo AS url, cdate FROM dogs_tbl ORDER BY breed ASC";
	    List<Dog> dogList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Dog.class));
	    model.addAttribute("dogdata", dogList);
	    return "showDog";
	}
	
	@GetMapping("/sortByDOB")
	public String sortDogsByDOB(Model model) {
	    String sql = "SELECT name, color, breed, photo AS url, cdate FROM dogs_tbl ORDER BY cdate ASC";
	    List<Dog> dogList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Dog.class));
	    model.addAttribute("dogdata", dogList);
	    return "showDog";
	}


}