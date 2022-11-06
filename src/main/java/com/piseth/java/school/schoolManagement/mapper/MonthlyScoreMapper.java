package com.piseth.java.school.schoolManagement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.piseth.java.school.schoolManagement.dto.MonthlyScoreDTO;
import com.piseth.java.school.schoolManagement.model.MonthlyScore;
import com.piseth.java.school.schoolManagement.service.SubjectService;

@Mapper(componentModel = "spring", uses = {SubjectService.class})
public interface MonthlyScoreMapper {
	MonthlyScoreMapper INSTANCE = Mappers.getMapper(MonthlyScoreMapper.class);
	
	@Mapping(target = "subject", source = "subjectId")
	MonthlyScore toMonthlyScore(MonthlyScoreDTO dto);
}
