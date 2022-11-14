package com.piseth.java.school.schoolManagement.service;

import com.piseth.java.school.schoolManagement.model.Subject;

public interface SubjectService {
	
	Subject save(Subject subject);

	Subject getById(Long id);

	Subject update(Long id, Subject subject);

	void delete(Long id);

}
