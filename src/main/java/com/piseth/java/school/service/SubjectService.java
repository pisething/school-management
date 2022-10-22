package com.piseth.java.school.service;

import java.util.List;

import com.piseth.java.school.model.Subject;

public interface SubjectService {
	    List<Subject> getAll();
		Subject addNew(Subject subject);
}
