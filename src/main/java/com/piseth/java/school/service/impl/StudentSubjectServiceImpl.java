package com.piseth.java.school.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.piseth.java.school.model.student.subject.StudentSubject;
import com.piseth.java.school.repository.StudentSubjectRepository;
import com.piseth.java.school.service.StudentSubjectService;

@Service
public class StudentSubjectServiceImpl implements StudentSubjectService{
	@Autowired
	private StudentSubjectRepository studentSubjectRepository;

	@Override
	public StudentSubject deleteStudentSubject(int id) {
		 StudentSubject student = getListStudentSubjects().stream()
														.filter(s->s.getStudent().getId()==id).findAny().orElse(null);
		 studentSubjectRepository.delete(student);
			return student;
		 
	}
	@Override
	public List<StudentSubject> getListStudentSubjects() {
		List<StudentSubject> findAll = studentSubjectRepository.findAll();
		Optional<List<StudentSubject>> optional= Optional.of(findAll);
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			return null;
		}
	}
	@Override
	public List<StudentSubject> getListStudentByMonth(String month) {
		List<StudentSubject> listStudent = getListStudentSubjects().stream()
																	.filter(s->s.getMonth().equals(month)).toList();
		return listStudent;
	}
	@Override
	public List<StudentSubject> getListStudentFall(String month) {
		
		return null;
	}

}
