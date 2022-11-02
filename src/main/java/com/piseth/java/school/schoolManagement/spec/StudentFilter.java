package com.piseth.java.school.schoolManagement.spec;

import com.piseth.java.school.schoolManagement.enums.Gender;

import lombok.Data;

@Data
public class StudentFilter {
	private String id;
	private String name;
	private Gender gender;
}
