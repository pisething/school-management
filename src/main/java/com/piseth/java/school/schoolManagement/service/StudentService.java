package com.piseth.java.school.schoolManagement.service;

import java.util.List;
import java.util.Map;

import com.piseth.java.school.schoolManagement.model.MonthlyScore;
import com.piseth.java.school.schoolManagement.model.Student;

public interface StudentService {
	Student register(Student student);

	Student getById(Long id);

	Student update(Long id, Student student);

	void delete(Long id);

	List<Student> getStudents(Map<String, String> params);
	
	void addMonthlyScore(Long studentId, MonthlyScore monthlyScore);
}
