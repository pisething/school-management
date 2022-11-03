package com.piseth.java.school.schoolManagement.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.piseth.java.school.schoolManagement.enums.Gender;
import com.piseth.java.school.schoolManagement.exception.ResourceNotFoundException;
import com.piseth.java.school.schoolManagement.model.Student;
import com.piseth.java.school.schoolManagement.property.StudentPropertyFilter;
import com.piseth.java.school.schoolManagement.repository.StudentRepository;
import com.piseth.java.school.schoolManagement.service.StudentService;
import com.piseth.java.school.schoolManagement.spec.StudentFilter;
import com.piseth.java.school.schoolManagement.spec.StudentSpec;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
	private final StudentRepository studentRepository;

	@Override
	public Student register(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student getById(Long id) {
		return studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("student", id));
	}

	@Override
	public Student update(Long id, Student student) {
		Student studentTarget = getById(id);
		BeanUtils.copyProperties(student, studentTarget, "id");
		return studentRepository.save(studentTarget);
	}

	@Override
	public void delete(Long id) {
		Student studentTarget = getById(id);
		studentRepository.delete(studentTarget);
	}

	@Override
	public List<Student> getStudents(Map<String, String> params) {
		StudentFilter studentFilter = new StudentFilter();

		if (params.containsKey(StudentPropertyFilter.ID)) {
			studentFilter.setId(params.get(StudentPropertyFilter.ID));
		}
		if (params.containsKey(StudentPropertyFilter.NAME)) {
			studentFilter.setName(params.get(StudentPropertyFilter.NAME));
		}
		if (params.containsKey(StudentPropertyFilter.GENDER)) {
			String genderString = params.get(StudentPropertyFilter.GENDER);
			if(genderString != null) {
				Gender gender = Gender.valueOf(genderString.toUpperCase());
				studentFilter.setGender(gender);
			}
		}
		StudentSpec studentSpec = new StudentSpec(studentFilter);
		return studentRepository.findAll(studentSpec);
	}

}
