package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
@RestController
@RequestMapping("/api/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	@PostMapping()
   public ResponseEntity<Student>saveStudent(@RequestBody Student student){
	   return new ResponseEntity<Student>(studentService.createStudent(student),HttpStatus.CREATED);
   }
	@GetMapping("{id}")
	public ResponseEntity<Student>findStudentByid(@PathVariable("id") long studentid){
		return new ResponseEntity<Student>(studentService.findStudentByid(studentid),HttpStatus.OK);
	}
	@PutMapping("{id}")
	public ResponseEntity<Student>updateStudet(@PathVariable("id") long id,@RequestBody Student student){
		return new ResponseEntity<Student>(studentService.updateStudent(student, id), HttpStatus.OK);
}
	@DeleteMapping("{id}")
	public ResponseEntity<String>deleteStudent(@PathVariable("id") long id){
		studentService.deleteStudentByid(id);
		return new ResponseEntity<String>("delete Succesfully",HttpStatus.OK);
	}
	@GetMapping("/all/student")
	public List<Student>findAllStudent(){
		return studentService.getAllStudent();
	}
}