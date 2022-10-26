package com.piseth.java.school.schoolManagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piseth.java.school.schoolManagement.dto.SubjectDTO;
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
}
