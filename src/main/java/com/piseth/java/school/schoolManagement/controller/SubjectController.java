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
import com.piseth.java.school.schoolManagement.mapper.StudentMapper;
import com.piseth.java.school.schoolManagement.mapper.SubjectMapper;
import com.piseth.java.school.schoolManagement.model.Subject;
import com.piseth.java.school.schoolManagement.service.SubjectService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/subject")
@RequiredArgsConstructor
public class SubjectController {
	
  private final SubjectService subjectService;
  @PostMapping
  public ResponseEntity<?>createSubject(@RequestBody SubjectDTO subjectdto){
	  Subject subject=SubjectMapper.INSTANCE.toEntity(subjectdto);
	  subject=subjectService.addSub(subject);
	  return ResponseEntity.status(HttpStatus.CREATED).body(SubjectMapper.INSTANCE.toDTO(subject));	  
  }
  @GetMapping("{id}")
  public ResponseEntity<?> getById(@PathVariable("id") Long id){
	  Subject subject=subjectService.getById(id);
	  return ResponseEntity.ok(SubjectMapper.INSTANCE.toDTO(subject));
  }
  @PutMapping("{id}")
  public ResponseEntity<?>update(@PathVariable("id") Long id,@RequestBody SubjectDTO subjectDTO ){
	  Subject subject=SubjectMapper.INSTANCE.toEntity(subjectDTO);
	  subject=subjectService.update(id, subject);
	  return ResponseEntity.ok(SubjectMapper.INSTANCE.toDTO(subject));
	  
  }
  @DeleteMapping("{id}")
  public ResponseEntity<?>deleteByid(@PathVariable("id") Long id){
	  subjectService.deleteById(id);
	  return ResponseEntity.noContent().build();
  }
  
 

}
