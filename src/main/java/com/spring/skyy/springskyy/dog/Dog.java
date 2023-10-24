package com.spring.skyy.springskyy.dog;

import java.sql.Timestamp;

public class Dog {

	String name;
	String color;
	String breed;
	String url;
	Timestamp cdate;

	public Dog() {
	}

	public Dog(String name, String color, String breed, String url) {
		this.name = name;
		this.color = color;
		this.breed = breed;
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Timestamp getCdate() {
		return cdate;
	}

	public void setCdate(Timestamp cdate) {
		this.cdate = cdate;
	}
	

}