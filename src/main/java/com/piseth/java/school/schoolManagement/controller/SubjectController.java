package com.piseth.java.school.schoolManagement.controller;

import java.util.List;

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
	public ResponseEntity<?> create(@RequestBody SubjectDTO subjectDto){
		Subject subject = SubjectMapper.INSTANCE.toSubject(subjectDto);
		subject = subjectService.addSubject(subject);		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(SubjectMapper.INSTANCE.toSubjectDTO(subject));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long id){
		Subject subjectById = subjectService.getById(id);
		return ResponseEntity.ok(SubjectMapper.INSTANCE.toSubjectDTO(subjectById));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody SubjectDTO subjectDto){
		Subject subject = SubjectMapper.INSTANCE.toSubject(subjectDto);
		subject = subjectService.update(subject, id);
		return ResponseEntity.ok(SubjectMapper.INSTANCE.toSubjectDTO(subject));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		subjectService.removeSubject(id);
		return ResponseEntity.ok("Subject Id{" + id + "} is deleted successfully!");
	}
	
	@GetMapping
	public ResponseEntity<?> getSubjectList(){
		List<SubjectDTO> subjects = subjectService.getSubjects()
				.stream()
				.map(subj -> SubjectMapper.INSTANCE.toSubjectDTO(subj))
				.toList();
		return ResponseEntity.ok(subjects);
	}
}
