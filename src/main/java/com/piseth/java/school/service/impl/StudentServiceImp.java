package com.piseth.java.school.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import com.piseth.java.school.dto.StudentDto;
import com.piseth.java.school.mapper.StudentMapper;
import com.piseth.java.school.model.Student;
import com.piseth.java.school.repository.StudentRepository;
import com.piseth.java.school.service.StudentService;

@Service
public class StudentServiceImp implements StudentService {
	@Autowired
	private StudentRepository repository;
	private StudentMapper mapper= new StudentMapper();

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
		Student student=searchById(id);
		student.setName(dto.getName());
		student.setSubjects(dto.getSubjects());
		student.setAClass(dto.getAClass());
		repository.save(student);
		return student;
	}

	@Override
	public void deleteById(int id) {
		repository.delete(searchById(id));
	}

	@Override
	public List<Student> getListStudent() {
		return  repository.findAll();
	}

	@Override
	public void InputScore() {
		

	}

	@Override
	public List<Student> listRange() {
		return null;
	}

	@Override
	public List<Student> studentFallByMonth(String month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> femaleAndGrade12() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void uploadSubjectToSys() {
		// TODO Auto-generated method stub

	}

	@Override
	public void insert10StudentToAClass() {
		// TODO Auto-generated method stub

	}

}
