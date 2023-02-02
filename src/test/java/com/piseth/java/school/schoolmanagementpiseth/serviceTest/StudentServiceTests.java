package com.piseth.java.school.schoolmanagementpiseth.serviceTest;

import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.context.SpringBootTest;

import com.piseth.java.school.schoolManagement.enums.Gender;
import com.piseth.java.school.schoolManagement.exception.ApiException;
import com.piseth.java.school.schoolManagement.model.Student;
import com.piseth.java.school.schoolManagement.repository.StudentRepository;
import com.piseth.java.school.schoolManagement.service.StudentService;
import com.piseth.java.school.schoolManagement.service.impl.StudentServiceImpl;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class StudentServiceTests {
    @Mock
	private StudentRepository studentRepository;
    private StudentService studentService;
	
	private Student student;
	long studentId=1;
	long studentIds=2;
	@BeforeEach
	private void setUp() {
		studentService=new StudentServiceImpl(studentRepository);
	    student=new Student(studentId, "Ponleu", Gender.MALE, 12, "AIB");
		when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));
	}
	@Test
	public void registerStudent() {
		Student student=new Student();
		student.setId((long) 1);
		student.setName("Ponleu");
		student.setGender(Gender.MALE);
		student.setClassName("AIB");
		student.setGrade(12);
		Student registerStudent = studentService.register(student);
		verify(studentRepository,times(1)).save(student);
	}
	@Test
	public void testFindStudentById() {
		Student byId = studentService.getById(studentId);
		assertNotNull(byId);
		assertEquals("Ponleu", byId.getName());
		assertEquals(12, byId.getGrade());
		assertEquals(Gender.MALE, byId.getGender());
		assertEquals("AIB", byId.getClassName());
	}
	@Test
	public void getByIdError() {
		when(studentRepository.findById(studentIds)).thenReturn(Optional.empty());
		assertThatThrownBy(()-> studentService.getById(studentIds)).isInstanceOf(ApiException.class)
		.hasMessageStartingWith("student",studentIds);
		
	}
	@Test
	public void updateStudentService() {
		Student student=new Student(studentId, "Ponleu", Gender.MALE, 12, "AIB");
		Student afterupdate = studentService.update(studentId, student);
		verify(studentRepository,times(1)).save(student);
	}
	@Test
	public void deleteStudent() {
		//long studentId=1;
		studentService.delete(studentId);
		verify(studentRepository,times(1)).delete(student);
	}
}
