package com.ibiztechno.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibiztechno.school.dto.StudentRequest;
import com.ibiztechno.school.mapper.EntityMapper;
import com.ibiztechno.school.model.Student;
import com.ibiztechno.school.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@PostMapping
	public ResponseEntity<Student> create(@RequestBody StudentRequest studentRequest){
		Student student=EntityMapper.toStudent(studentRequest);
		student=studentService.save(student);
		return ResponseEntity.ok(student);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Student> getById(@PathVariable("id") int id){
		return ResponseEntity.ok(studentService.getById(id));
	}
	
}
