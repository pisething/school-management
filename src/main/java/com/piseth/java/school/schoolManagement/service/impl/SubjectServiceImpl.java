package com.piseth.java.school.schoolManagement.service.impl;

import org.springframework.stereotype.Service;

import com.piseth.java.school.schoolManagement.exception.ResourceNotFoundException;
import com.piseth.java.school.schoolManagement.model.Subject;
import com.piseth.java.school.schoolManagement.repository.SubjectRepository;
import com.piseth.java.school.schoolManagement.service.SubjectService;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Service
@Data
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {
	
	private final SubjectRepository subjectRepository;
    
	@Override
	public Subject getById(Long id) {
		return subjectRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("subject", id));
	}

	@Override
	public Subject save(Subject subject) {
		return subjectRepository.save(subject);
	}
	
	@Override
	public Subject update(Long id, Subject subject) {
		if(getById(id)!=null) {
			return subjectRepository.save(subject);
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		subjectRepository.delete(getById(id));
	}

}
