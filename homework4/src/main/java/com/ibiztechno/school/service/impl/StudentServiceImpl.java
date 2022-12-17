package com.ibiztechno.school.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.ibiztechno.school.model.Student;
import com.ibiztechno.school.repository.StudentRepository;
import com.ibiztechno.school.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	 @Override
	public Student save(Student entity) {
		return studentRepository.save(entity);
	}
	 
	 @Override
	public Student getById(Integer id) {
		Optional<Student> studentOptional=studentRepository.findById(id);
		
		if(studentOptional.isPresent()) {
			return studentOptional.get();
		}else{
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND, String.format("Student not found for id=%d", id));
		}
	}
}
