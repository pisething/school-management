package com.piseth.java.school.schoolmanagementpiseth.Service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.piseth.java.school.schoolManagement.enums.Gender;
import com.piseth.java.school.schoolManagement.model.Student;
import com.piseth.java.school.schoolManagement.repository.StudentRepository;
import com.piseth.java.school.schoolManagement.service.StudentService;
import com.piseth.java.school.schoolManagement.service.impl.StudentServiceImpl;
import com.piseth.java.school.schoolManagement.spec.StudentFilter;
import com.piseth.java.school.schoolManagement.spec.StudentSpec;
public class StudentServiceTest {
       @Mock
       private StudentRepository repository;
       private StudentSpec spec;
       private StudentService service;
       private Map<String,String> params;
       private Student student;
       private StudentFilter filter;
       
       @BeforeEach
       public void setUp() {
    	   repository = mock(StudentRepository.class);
    	   service = new StudentServiceImpl(repository);
    	   student = new Student();
    	   
    	   student.setId(1L);
    	   student.setName("Dara");
    	   student.setGender(Gender.MALE);
    	   student.setGrade(12);
    	   student.setClassName("A");
    	   
    	   //Filter
    	   filter = new StudentFilter();
    	   filter.setId("1");
    	   filter.setName("Dara");
    	   filter.setGender(Gender.MALE);
    	   
    	   
	    	 //Parameter getStudents
	   		params = new HashMap<>();
	   		params.put("id", "1");
	   		params.put("name", "Dara");
	   		params.put("gender", "MALE");
       }
       
       
       @Test
       public void registerTest() {
    	   //GIVEN
    	   
    	   //WHEN
    	   when(repository.save(student)).thenReturn(student);
    	   service.register(student);
    	   //THEN
    	   verify(repository,times(1)).save(student);
    	   
       }
       @Test
       public void getByIdTest() {
    	   //GIVEN
    	   
    	   //WHEN
    	   when(repository.findById(student.getId())).thenReturn(Optional.of(student));
    	   Student getStudent = service.getById(1L);
    	   
    	   //THEN
    	   assertNotNull(getStudent);
       }
       
   	@Test
   	public void getStudents() {
   		//GIVEN
   		spec = new StudentSpec(filter);
	   	//Parameter getStudents
	   		params = new HashMap<>();
	   		params.put("id", "1");
	   		params.put("name", "Dara");
	   		params.put("gender", "MALE");
	   		
   		//WHEN
   		when(repository.findAll(spec)).thenReturn( List.of(student));
   		List<Student> students = service.getStudents(params,spec);
   		//log.info(students.toString());
  
   		//THEN 
   		assertNotEquals(0,students.size());
   		assertEquals(1L, students.get(0).getId());
   		assertEquals("Dara",  students.get(0).getName());
   		assertEquals(Gender.MALE,  students.get(0).getGender());
   		assertEquals(12,  students.get(0).getGrade());
   		assertEquals("A",  students.get(0).getClassName());
   		
   	}
   	
       
}
