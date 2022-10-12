package com.ibiztechno.school.service;

import java.util.List;

import com.ibiztechno.school.dto.StudentRequest;
import com.ibiztechno.school.model.Student;

public interface StudentService {
	Student save(Student entity);

	Student getById(Integer id);

	Student update(Integer id, StudentRequest dto);
	
	void delete(Integer id);
	
	List<Student> getStudents();
	
}
