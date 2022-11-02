package com.piseth.java.school.schoolManagement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.piseth.java.school.schoolManagement.dto.SubjectDTO;
import com.piseth.java.school.schoolManagement.model.Subject;
@Mapper
public interface SubjectMapper {
   SubjectMapper INSTANCE=Mappers.getMapper(SubjectMapper.class);
   Subject toEntity(SubjectDTO dto);
   SubjectDTO toDTO(Subject entity);
}
