package com.piseth.java.school.schoolManagement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.piseth.java.school.schoolManagement.dto.StudentDTO;
import com.piseth.java.school.schoolManagement.model.Student;
import com.piseth.java.school.schoolManagement.model.Subject;

@Mapper
public interface StudentMapper {
	StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);
	
	Student toEntity(StudentDTO dto);
	
	StudentDTO toDTO(Student student);

}
