package com.piseth.java.school.schoolManagement.service.impl;

import java.security.cert.CollectionCertStoreParameters;
import java.util.HashMap;
import java.util.List;
import java.util.Map;import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.piseth.java.school.schoolManagement.enums.Gender;
import com.piseth.java.school.schoolManagement.exception.ApiException;
import com.piseth.java.school.schoolManagement.exception.ResourceNotFoundException;
import com.piseth.java.school.schoolManagement.model.MonthlyScore;
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

	@Override
	public void addMonthlyScore(Long studentId, MonthlyScore monthlyScore) {
		Student student = getById(studentId);
		student.getMonthlyScores().add(monthlyScore);
		studentRepository.save(student);
	}

	@Override
	public List<Student> listRange(Short month) {
		List<Student> all = studentRepository.findAll();
		if(month<1||month>12) {
			throw new  ApiException();
		} 
		return all.stream()
					.filter(s->s.getMonthlyScores()
							.stream()
							.filter(s2->month==s2.getMonth())
							.findAny().orElse(null)!=null)
							.sorted((s1,s2)->
								(totalScore(s1)>totalScore(s2))?1:-1).toList();
		
	}
	private Double totalScore(Student stu) {
		return stu.getMonthlyScores().stream()
				  .map(sc1->sc1.getScore())
				  .mapToDouble(d1->d1).sum();
	}

}
