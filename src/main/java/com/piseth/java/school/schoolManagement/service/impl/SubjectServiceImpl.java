package com.piseth.java.school.schoolManagement.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.piseth.java.school.schoolManagement.exception.ResourceNotFoundException;
import com.piseth.java.school.schoolManagement.model.Subject;
import com.piseth.java.school.schoolManagement.repository.SubjectRepository;
import com.piseth.java.school.schoolManagement.service.SubjectService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {
	
	private final SubjectRepository subjectRepository;

	@Override
	public Subject addSubject(Subject subject) {
		return subjectRepository.save(subject);
	}

	@Override
	public Subject getById(Long id) {
		return subjectRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Subject", id));
	}

	@Override
	public Subject update(Subject subject, Long id) {
		Subject targetSubject = getById(id);
		BeanUtils.copyProperties(subject, targetSubject, "id");
		return subjectRepository.save(targetSubject);
	}

	@Override
	public void removeSubject(Long id) {
		Subject targetSubject = getById(id);
		subjectRepository.delete(targetSubject);
	}

	@Override
	public List<Subject> getSubjects() {
		return subjectRepository.findAll();
	}

}
