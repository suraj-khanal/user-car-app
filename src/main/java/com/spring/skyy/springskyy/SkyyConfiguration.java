package com.spring.skyy.springskyy;


import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.skyy.springskyy.dog.Dog;

@Configuration
public class SkyyConfiguration {
	
	//when we return DataSource
	@Bean
    public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/kia_db?useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("Nepal@123");
        return dataSource;
    }
	
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		
		return new JdbcTemplate(dataSource());
	}
	
	@Bean
	public Dog getDog(){
		return new Dog("tommy","white","test","NA");
	}

}