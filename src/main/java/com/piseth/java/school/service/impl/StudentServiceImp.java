package com.piseth.java.school.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import com.piseth.java.school.dto.StudentDto;
import com.piseth.java.school.model.Student;
import com.piseth.java.school.repository.StudentRepository;
import com.piseth.java.school.service.StudentService;
import com.piseth.java.school.service.StudentSubjectService;

//import lombok.extern.slf4j.Slf4j;
//@Slf4j
@Service
public class StudentServiceImp implements StudentService {
	@Autowired
	private StudentRepository repository;
	@Autowired
	private StudentSubjectService studentSubjectService;
	@Override
	public void saveStudent(Student student) {
		 repository.save(student);
	}

	@Override
	public Student searchById(int id) {
		Optional<Student> student = repository.findById(id);
		if(student.isPresent()) {
			return student.get();
		}else {
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND,String.format("Don't found id =",student));
		}
	}

	@Override
	public Student updateByID(int id,StudentDto dto) {
		Student student = new Student();
		student.setId(id);
		student.setName(dto.getName());
		student.setGender(dto.getGender());
		student.setAge(dto.getAge());
		repository.save(student);
		return student;
	}

	@Override
	public Student deleteById(int id) {
		studentSubjectService.deleteStudentSubject(id);
		Student stu= searchById(id);
		repository.delete(stu);
		return stu;
	}

	@Override
	public List<Student> getListStudent() {
		  List<Student> findAll = repository.findAll();
		  return findAll;
	}


}
