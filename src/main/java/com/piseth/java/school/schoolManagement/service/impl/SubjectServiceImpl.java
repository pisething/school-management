package com.piseth.java.school.schoolManagement.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.piseth.java.school.schoolManagement.exception.ResourceNotFoundException;
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
	@Override
	public Subject getById(Long id) {
		// TODO Auto-generated method stub
		return subjectrepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("subject", id));
	}
	@Override
	public Subject update(Long id, Subject subject) {
		// TODO Auto-generated method stub
		Subject subjectTarget=getById(id);
		BeanUtils.copyProperties(subject, subjectTarget,"id");
		return subjectrepository.save(subjectTarget);
	}
	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		Subject subjectTarget=getById(id);
		subjectrepository.delete(subjectTarget);
		
	}

	
}
