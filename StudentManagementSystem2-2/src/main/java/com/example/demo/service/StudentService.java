package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentService {
	Student createStudent(Student student);
	Student findStudentByid(Long id);
	Student updateStudent(Student student , Long id);
	void deleteStudentByid(Long id);
    List<Student>getAllStudent();
    
}
