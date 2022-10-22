package com.piseth.java.school.service;

import java.util.List;

import com.piseth.java.school.dto.StudentDto;
import com.piseth.java.school.model.Student;

public interface StudentService {
	
	void saveStudent(Student student);
	Student searchById(int id);
	Student updateByID(int id,StudentDto studentDto);
	Student deleteById(int id);
	List<Student> getListStudent();
}
