package com.piseth.java.school.schoolManagement.service.impl;

import org.springframework.stereotype.Service;

import com.piseth.java.school.schoolManagement.model.Subject;
import com.piseth.java.school.schoolManagement.repository.SubjectRepository;
import com.piseth.java.school.schoolManagement.service.SubjectService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService{
  
  private final SubjectRepository subjectrepository;
	@Override
	public Subject addSub(Subject subject) {
		// TODO Auto-generated method stub
		return subjectrepository.save(subject) ;
	}

	
}
