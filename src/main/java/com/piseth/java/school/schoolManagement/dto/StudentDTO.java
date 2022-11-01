package com.piseth.java.school.schoolManagement.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class StudentDTO {
	private Long id;
	private String name;
	private LocalDate dateOfBirth;
	private String gender;
}
