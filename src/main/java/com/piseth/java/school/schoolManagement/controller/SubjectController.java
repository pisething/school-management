package com.piseth.java.school.schoolManagement.controller;

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

import com.piseth.java.school.schoolManagement.dto.SubjectDTO;
import com.piseth.java.school.schoolManagement.mapper.SubjectMapper;
import com.piseth.java.school.schoolManagement.model.Subject;
import com.piseth.java.school.schoolManagement.service.SubjectService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/subjects")
@RequiredArgsConstructor
public class SubjectController {
	private final SubjectService subjectService;

	@PostMapping
	public ResponseEntity<?> create(@RequestBody SubjectDTO subjectDTO) {
		Subject subject = SubjectMapper.INSTANCE.toEntity(subjectDTO);
		subject = subjectService.save(subject);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(SubjectMapper.INSTANCE.toDTO(subject));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {
		Subject subject = subjectService.getById(id);
		return ResponseEntity.ok(SubjectMapper.INSTANCE.toDTO(subject));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody SubjectDTO subjectDTO) {
		Subject subject = SubjectMapper.INSTANCE.toEntity(subjectDTO);
		subject = subjectService.update(id, subject);
		return ResponseEntity.ok(SubjectMapper.INSTANCE.toDTO(subject));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		subjectService.delete(id);
		return ResponseEntity.noContent().build();
	}
 	
}
