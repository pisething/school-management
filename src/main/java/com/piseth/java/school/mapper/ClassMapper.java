package com.piseth.java.school.mapper;

import org.springframework.stereotype.Component;

import com.piseth.java.school.dto.ClassDto;
import com.piseth.java.school.model.AClass;
import com.piseth.java.school.model.Student;
@Component
public class ClassMapper {
		public ClassDto toClassDto(AClass aClass) {
			   ClassDto dto =new ClassDto();
			   dto.setName(aClass.getName());
			   dto.setGrade(aClass.getGrade());
			   return dto;
		}
		public AClass toClass(ClassDto classDto) {
			   AClass aclass =new AClass();
			   aclass.setName(classDto.getName());
			   aclass.setGrade(classDto.getGrade());
			   return aclass;
		}
}
