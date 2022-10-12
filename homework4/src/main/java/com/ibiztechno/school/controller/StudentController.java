package com.ibiztechno.school.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibiztechno.school.dto.StudentRequest;
import com.ibiztechno.school.dto.StudentResponse;
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
	
	@PutMapping("{id}")
	public ResponseEntity<Student> update(@PathVariable("id") int id,@RequestBody StudentRequest studentRequest){
		return ResponseEntity.ok(studentService.update(id, studentRequest));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") int id){
		studentService.delete(id);
		return ResponseEntity.ok().build();
	}
	
//	@GetMapping()
//	public ResponseEntity<?> list(){
//		return ResponseEntity.ok(studentService.getStudents());
//	}
	
	@GetMapping()
	public ResponseEntity<?> list(){
//		List<Student> students=studentService.getStudents();
		
		List<StudentResponse> listStudent= studentService.getStudents()
				.stream().map(b->EntityMapper.toStudentResponse(b))
				.toList();
				//.collect(Collectors.toList());
		
		return ResponseEntity.ok(listStudent);
	}
	
}
