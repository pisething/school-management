package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
    private StudentRepository studentRepository;
	
	@Override
	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}
	@Override
	public Student findStudentByid(Long id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id).orElseThrow(()->new 
				ResourceNotFoundException("Student","id",id));
	}
	@Override
	public Student updateStudent(Student student, Long id) {
		// TODO Auto-generated method stub
		Student existingStudent=studentRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("Student", "id", id));
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setSubject(student.getSubject());
		existingStudent.setScore(student.getScore());
		
		studentRepository.save(existingStudent);
		return existingStudent;
		
	}
	@Override
	public void deleteStudentByid(Long id) {
		// TODO Auto-generated method stub
		studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student", "id", id));
		studentRepository.deleteById(id);
		
	}
	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

}
