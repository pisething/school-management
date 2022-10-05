package com.ibiztechno.school.service;

import com.ibiztechno.school.model.Student;

public interface StudentService {
	Student save(Student entity);
	Student getById(Integer id);
}
