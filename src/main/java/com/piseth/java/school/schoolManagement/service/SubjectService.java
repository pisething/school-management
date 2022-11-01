package com.piseth.java.school.schoolManagement.service;

import java.util.List;

import com.piseth.java.school.schoolManagement.model.Subject;

public interface SubjectService {
	Subject addSubject(Subject subject);
	Subject getById(Long id);
	Subject update(Subject subject, Long id);
	void removeSubject(Long id);
	List<Subject> getSubjects();
}
