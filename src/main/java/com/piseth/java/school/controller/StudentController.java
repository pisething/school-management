package com.piseth.java.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.piseth.java.school.dto.StudentDto;
import com.piseth.java.school.mapper.StudentMapper;
import com.piseth.java.school.model.Student;
import com.piseth.java.school.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService service ;
	@Autowired
	private StudentMapper mapper ;
	//1. Save a student 
	@PostMapping(path = "/save")
	public ResponseEntity<Student> create(@RequestBody StudentDto studentDto) {
		Student stu =mapper.toStudent(studentDto);
		service.saveStudent(stu);
		return ResponseEntity.ok(stu);
	}
	//2.Search student by Id
	@GetMapping(path = "/search")
	public ResponseEntity<Student> searchById(@RequestParam int id){
		return ResponseEntity.ok(service.searchById(id));
	}
	//3.Update student()
	@PutMapping(path ="/update")
	public ResponseEntity<Student> updateById(@RequestParam int id,@RequestBody StudentDto studentDto) {
		Student stu=service.updateByID(id, studentDto);
		return ResponseEntity.ok(stu);
	}
	
     @GetMapping
     public ResponseEntity<List<Student>> getAllStudent(){
		return ResponseEntity.ok(service.getListStudent());
     }
}
