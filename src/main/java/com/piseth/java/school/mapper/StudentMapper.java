package com.piseth.java.school.mapper;

import org.springframework.stereotype.Component;

import com.piseth.java.school.dto.StudentDto;
import com.piseth.java.school.model.Student;

import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j
public class StudentMapper {
      public Student toStudent(StudentDto studentDto) {
    	  Student stu = new Student();
    	  stu.setName(studentDto.getName());
    	  stu.setSubjects(studentDto.getSubjects());
    	  stu.setAClass(studentDto.getAClass());
    	  return stu;
      }
      public StudentDto toStudentDto(Student student) {
    	  StudentDto dto= new StudentDto();
    	  dto.setName(student.getName());
    	  return dto;
      }
}
