package com.ibiztechno.school.dto;

import lombok.Data;

@Data
public class StudentRequest {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
