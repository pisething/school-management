package com.ibiztechno.school.mapper;

import com.ibiztechno.school.dto.StudentRequest;
import com.ibiztechno.school.model.Student;

public class EntityMapper {
	public static Student toStudent(StudentRequest dto) {
		Student student=new Student();
		student.setName(dto.getName());
		return student;
	}
}
