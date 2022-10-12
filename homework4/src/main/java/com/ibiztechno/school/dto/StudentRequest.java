package com.ibiztechno.school.dto;

import lombok.Data;

@Data
public class StudentRequest {
	private String name;
	private String gender;
	private Integer grade;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	
	
}
