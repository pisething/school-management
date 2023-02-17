package com.piseth.java.school.schoolmanagementpiseth.Service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.piseth.java.school.schoolManagement.enums.Gender;
import com.piseth.java.school.schoolManagement.exception.BadRequestException;
import com.piseth.java.school.schoolManagement.model.MonthlyScore;
import com.piseth.java.school.schoolManagement.model.Student;
import com.piseth.java.school.schoolManagement.model.Subject;
import com.piseth.java.school.schoolManagement.repository.MonthlyScoreRepository;
import com.piseth.java.school.schoolManagement.repository.StudentRepository;
import com.piseth.java.school.schoolManagement.service.MonthlyScoreService;
import com.piseth.java.school.schoolManagement.service.impl.MonthlyScoreServiceImpl;
import com.piseth.java.school.schoolManagement.spec.MonthlyScoreFilter;
import com.piseth.java.school.schoolManagement.spec.MonthlyScoreSpec;
import com.piseth.java.school.schoolManagement.spec.StudentFilter;
public class MonthlyScoreServiceTest {
       private StudentRepository studentRepository;
       private MonthlyScoreRepository monthlyScoreRepository;
       private MonthlyScoreService monthlyScoreService;
       private MonthlyScoreSpec montlySpec;
       private MonthlyScoreFilter monthlyFilter;
       private MonthlyScore monthlyScore;
       private Map<String,String> params;
       private StudentFilter filter;
       private Student student;
       private Subject subject;
       
       @BeforeEach
       public void setUp() {
    	   studentRepository = mock(StudentRepository.class);
    	   monthlyScoreRepository = mock(MonthlyScoreRepository.class);
    	   monthlyScoreService = new MonthlyScoreServiceImpl(monthlyScoreRepository,studentRepository);
    	   monthlyFilter = new MonthlyScoreFilter();
    	   monthlyScore = new MonthlyScore();
    	   student = new Student();
    	   subject = new Subject();
    	   params = new HashMap<>();
    	   
    	   // Student 
    	   student.setId(1L);
    	   student.setName("Dara");
    	   student.setGender(Gender.MALE);
    	   student.setGrade(12);
    	   student.setClassName("A");
    	   
    	   // Subject
   		   subject.setId(1L);
   		   subject.setName("Math");
    	   
   		   // Monthly Score
    	   monthlyScore.setId(1L);
    	   monthlyScore.setStudent(student);
    	   monthlyScore.setSubject(subject);
    	   monthlyScore.setScore(98.0);
    	   monthlyScore.setMonth((short) 12);
    	   monthlyScore.setYear((short) 2022);
    	   
    	   
    	   //Filter
    	   monthlyFilter.setStudentId(1L);
    	   monthlyFilter.setSubjectIds(List.of(1L));
    	   monthlyFilter.setStudentIds(List.of(1L));
    	   monthlyFilter.setYear((short) 2022);
    	   monthlyFilter.setMonth((short) 11);
    	   monthlyFilter.setGrade((short) 12);
    	   monthlyFilter.setClassName("A");
    	   
    	   
	    	//Parameter
	   		params.put("studentId","1");
	   		params.put("subjectId","1");
	   		params.put("score", "8.0");
	   		params.put("grade", "12");
	   		params.put("className", "A");
	   		params.put("year", "2022");
	   		params.put("month", "11");
       }
       
       @Test
       public void addMonthlyScoreTest() {
    	   //GIVEN
    	   
    	   //WHEN
    	   when(monthlyScoreRepository.save(monthlyScore)).thenReturn(monthlyScore);
    	   monthlyScoreService.addMonthlyScore(monthlyScore);
    	   
    	   //THEN
    	   verify(monthlyScoreRepository,times(1)).save(monthlyScore);
    	   
       }
       @Test
       public void monthlyFilterTest() {
    	   //GIVEN
    	   montlySpec = new MonthlyScoreSpec(monthlyFilter);
    	   
    	   //WHEN
    	   when(monthlyScoreRepository.findAll(montlySpec)).thenReturn(List.of(monthlyScore));
    	   List<MonthlyScore> monthlyScoreList = monthlyScoreService.getMonthlyScore(params,montlySpec);
    	   
    	   //THEN
    	   assertNotEquals(0,monthlyScoreList.size());
       }
       @Test
       public void listScore() {
    	   //GIVEN
    	   montlySpec = new MonthlyScoreSpec(monthlyFilter);
    	   
    	   //WHEN 
    	   when(monthlyScoreRepository.findAll(montlySpec)).thenReturn(List.of(monthlyScore));
    	   Map<String, Double> listScore = monthlyScoreService.listScores(params,montlySpec);
    	   
    	   //THEN
    	   assertNotEquals(0,listScore.size()); 
       }
       @Test
       public void listScoreParamsBlank() {
    	   //GIVEN
    	   montlySpec = new MonthlyScoreSpec(monthlyFilter);
    	   params.put("studentId", "");
    	   
    	   //WHEN
    	   when(monthlyScoreRepository.findAll(montlySpec)).thenReturn(List.of());
    	  // BadRequestException exception = Assertions.assertThrows(BadRequestException.class, () -> monthlyScoreService.listScores(params, montlySpec));
    	   
    	   //THEN
    	   
    	   assertThatThrownBy(() -> monthlyScoreService.listScores(params, montlySpec))
    			   .isInstanceOf(BadRequestException.class)
    			   .hasMessageStartingWith("studentId is blank!");
    	 
       }
       

   	
       
}
