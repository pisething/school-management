package com.piseth.java.school.schoolManagement.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piseth.java.school.schoolManagement.dto.MonthlyScoreDTO;
import com.piseth.java.school.schoolManagement.dto.StudentDTO;
import com.piseth.java.school.schoolManagement.mapper.MonthlyScoreMapper;
import com.piseth.java.school.schoolManagement.mapper.StudentMapper;
import com.piseth.java.school.schoolManagement.model.MonthlyScore;
import com.piseth.java.school.schoolManagement.model.Student;
import com.piseth.java.school.schoolManagement.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
	private final StudentService studentService;
	private final MonthlyScoreMapper monthlyScoreMapper;

	@PostMapping
	public ResponseEntity<?> create(@RequestBody StudentDTO studentDTO) {
		Student student = StudentMapper.INSTANCE.toEntity(studentDTO);
		student = studentService.register(student);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(StudentMapper.INSTANCE.toDTO(student));
	}

	@GetMapping("{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {
		Student student = studentService.getById(id);
		return ResponseEntity.ok(StudentMapper.INSTANCE.toDTO(student));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody StudentDTO studentDTO) {
		Student student = StudentMapper.INSTANCE.toEntity(studentDTO);
		student = studentService.update(id, student);
		return ResponseEntity.ok(StudentMapper.INSTANCE.toDTO(student));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		studentService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<?> getStudentList(@RequestParam Map<String, String> params) {
		List<StudentDTO> list = studentService.getStudents(params)
			.stream()
			.map(st -> StudentMapper.INSTANCE.toDTO(st))
			.toList();
		return ResponseEntity.ok(list);
	}
	
	@PutMapping("/{id}/monthlyScore")
	public ResponseEntity<?> addMonthlyScore(@PathVariable("id") Long id, @RequestBody MonthlyScoreDTO monthlyScoreDTO) {
		MonthlyScore monthlyScore = monthlyScoreMapper.toMonthlyScore(monthlyScoreDTO);
		studentService.addMonthlyScore(id, monthlyScore);
		return ResponseEntity.ok().build();
	}
}
