package com.piseth.java.school.schoolManagement.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.piseth.java.school.schoolManagement.dto.SubjectDTO;
import com.piseth.java.school.schoolManagement.exception.ResourceNotFoundException;
import com.piseth.java.school.schoolManagement.model.Subject;
import com.piseth.java.school.schoolManagement.property.SubjectPropertyFilter;
import com.piseth.java.school.schoolManagement.repository.SubjectRepository;
import com.piseth.java.school.schoolManagement.service.SubjectService;
import com.piseth.java.school.schoolManagement.subject.spac.SubjectFilter;
import com.piseth.java.school.schoolManagement.subject.spac.SubjectSpec;

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
	@Override
	public List<Subject> getAllSubject(Map<String, String> param) {
		SubjectFilter file=new SubjectFilter();
		if(param.containsKey(SubjectPropertyFilter.ID)) {
			file.setId(param.get(SubjectPropertyFilter.ID));
		}
		if(param.containsKey(SubjectPropertyFilter.NAME)) {
			file.setName(param.get(SubjectPropertyFilter.NAME));
		}
		SubjectSpec subjectSpec=new SubjectSpec(file);
		// TODO Auto-generated method stub
		return subjectrepository.findAll();
	}

	
}
