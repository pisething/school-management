package com.piseth.java.school.schoolManagement;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SchoolManagementPisethApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolManagementPisethApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper(){
		// @formatter:off
		return new ModelMapper();
	}

}
