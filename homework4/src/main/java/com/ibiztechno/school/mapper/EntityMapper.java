package com.ibiztechno.school.mapper;

import com.ibiztechno.school.dto.StudentRequest;
import com.ibiztechno.school.dto.StudentResponse;
import com.ibiztechno.school.model.Student;

public class EntityMapper {
	public static Student toStudent(StudentRequest dto) {
		Student student=new Student();
		
		student.setName(dto.getName());
		student.setGender(dto.getGender());
		student.setGrade(dto.getGrade());
		
		return student;
	}
	
	public static StudentResponse toStudentResponse(Student entity) {
		StudentResponse studentResponse=new StudentResponse();
		
		studentResponse.setName(entity.getName());
		studentResponse.setGender(entity.getGender());
		studentResponse.setGrade(entity.getGrade());
		
		return studentResponse;
	}
}
