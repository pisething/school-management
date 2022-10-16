package com.piseth.java.school.dto;

import java.util.List;

import com.piseth.java.school.model.AClass;
import com.piseth.java.school.model.Subject;

import lombok.Data;

@Data
public class StudentDto {
	private String name; 
	private List<Subject> subjects;
	private AClass aClass;
}
