package com.piseth.java.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piseth.java.school.dto.ClassDto;
import com.piseth.java.school.mapper.ClassMapper;
import com.piseth.java.school.model.AClass;
import com.piseth.java.school.model.MonthOfYear;
import com.piseth.java.school.service.ClassService;

@RestController
@RequestMapping("/class")
public class ClassController {
	@Autowired
	private ClassService service;
	@Autowired
	ClassMapper classMapper;
	@GetMapping("/getAll")
	public ResponseEntity<List<AClass>> getAllClasses() {
		List<AClass> aclass= service.getAllClasses();
		return ResponseEntity.ok(aclass);
	}
	
	@PostMapping
	public AClass addNewClass(@RequestBody ClassDto classDto) {
		AClass aclass= classMapper.toClass(classDto);
		service.saveAClass(aclass);
		return aclass;
	}
	@GetMapping(name = "/search")
	public ResponseEntity<AClass> searchClassById(@RequestParam int id){
		return ResponseEntity.ok( service.searchClassById(id));
	}

}
