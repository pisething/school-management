package com.ibiztechno.school.service.impl;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.ibiztechno.school.dto.StudentRequest;
import com.ibiztechno.school.model.Student;
import com.ibiztechno.school.repository.StudentRepository;
import com.ibiztechno.school.service.StudentService;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
	 
	@Override
	public Student update(Integer id, StudentRequest dto) {
		Student student =getById(id);
		
		student.setName(dto.getName());
		student.setGender(dto.getGender());
		student.setGrade(dto.getGrade());
		
		return studentRepository.save(student);
	}
	
	@Override
	public void delete(Integer id) {
		Student student =getById(id);
		
		
		studentRepository.delete(student);
//		log.info("Student id: %d is deleted".formatted(id));
		
	}
	
	@Override
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}
}
