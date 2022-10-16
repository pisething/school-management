package com.piseth.java.school.service;

import java.util.List;
import com.piseth.java.school.model.Student;

public interface StudentService {
	
	//1. Register Student
	void saveStudent(Student student);
	//2. Search Id by Id
	Student searchById(int id);
	//3. Update Student by Id
	void updateByID(int id,Student student);
	//4. Delete Student By Id
	void deleteById(int id);
	//5. Show all students
	List<Student> getListStudent();
	//6. Input Score to all subjects
	void InputScore();
	//7. Rang Score per month
	List<Student> listRange();
	//8. Show student fall by month
	List<Student> studentFallByMonth(String month);
	//9. Show Female and study grade 12
	List<Student> femaleAndGrade12();
	//10. Insert Subject to System
	void uploadSubjectToSys();
	//11. Input 10 people to a class
	void insert10StudentToAClass();
}
