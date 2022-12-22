package com.piseth.java.school.schoolManagement.service.impl;

import static com.piseth.java.school.schoolManagement.property.MonthlyScorePropertyFilter.CLASS_NAME;
import static com.piseth.java.school.schoolManagement.property.MonthlyScorePropertyFilter.GRADE;
import static com.piseth.java.school.schoolManagement.property.MonthlyScorePropertyFilter.MONTH;
import static com.piseth.java.school.schoolManagement.property.MonthlyScorePropertyFilter.YEAR;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;
import org.springframework.util.NumberUtils;

import com.piseth.java.school.schoolManagement.dto.RankDTO;
import com.piseth.java.school.schoolManagement.model.MonthlyScore;
import com.piseth.java.school.schoolManagement.model.Student;
import com.piseth.java.school.schoolManagement.property.MonthlyScorePropertyFilter;
import com.piseth.java.school.schoolManagement.repository.MonthlyScoreRepository;
import com.piseth.java.school.schoolManagement.repository.StudentRepository;
import com.piseth.java.school.schoolManagement.service.MonthlyScoreService;
import com.piseth.java.school.schoolManagement.spec.MonthlyScoreFilter;
import com.piseth.java.school.schoolManagement.spec.MonthlyScoreSpec;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MonthlyScoreServiceImpl implements MonthlyScoreService{
	private final MonthlyScoreRepository monthlyScoreRepository;
	private final StudentRepository studentRepository;

	@Override
	public void addMonthlyScore(MonthlyScore monthlyScore) {
		monthlyScoreRepository.save(monthlyScore);
	}

	@Override
	public List<MonthlyScore> getMonthlyScore(Map<String, String> params) {
		
		MonthlyScoreFilter filter = new MonthlyScoreFilter();
		if(params.containsKey(GRADE)) {
			filter.setGrade(NumberUtils.parseNumber(params.get(GRADE), Short.class));
		}
		if(params.containsKey(CLASS_NAME)) {
			filter.setClassName(params.get(CLASS_NAME));
		}
		if(params.containsKey(YEAR)) {
			filter.setYear(NumberUtils.parseNumber(params.get(YEAR), Short.class));
		}
		if(params.containsKey(MONTH)) {
			filter.setMonth(NumberUtils.parseNumber(params.get(MONTH), Short.class));
		}
		MonthlyScoreSpec spec = new MonthlyScoreSpec(filter);
		
		return monthlyScoreRepository.findAll(spec);
	}

	@Override
	public List<RankDTO> getRankDTO(Map<String, String> params) {
			
			Map<Student, List<MonthlyScore>> mapMonthlyScore = getMonthlyScore(params)
				.stream()
				.collect(Collectors.groupingBy(MonthlyScore::getStudent));
			
			List<Long> studentIds = mapMonthlyScore.keySet()
					.stream()
					.map(Student::getId)
					.toList();
			
			Map<Long, Student> mapStudent = studentRepository.findAllById(studentIds)
				.stream()
				.collect(Collectors.toMap(Student::getId, Function.identity()));
			
			List<RankDTO> list = mapMonthlyScore.entrySet().stream()
				.map(entry -> {
					Long studentId = entry.getKey().getId();
					Student student = mapStudent.get(studentId);
					List<MonthlyScore> monthlyScores = entry.getValue();
					RankDTO rankDTO = toRankDTO(student, monthlyScores);
					return rankDTO;
				})
				.sorted((a,b) -> b.getTotalScore().compareTo(a.getTotalScore()))
				.toList();
			
			List<RankDTO> ranklist = IntStream.range(0, list.size())
				.mapToObj(index -> {
					RankDTO rank = list.get(index);
					rank.setRank(index+1);
					return rank;
				})
				.toList();
			
			
		return ranklist;
	}
	
	private RankDTO toRankDTO(Student student, List<MonthlyScore> mapStudent) {
		RankDTO rankDTO = new RankDTO();
		
		Double totalScore = mapStudent.stream()
			.collect(Collectors.summingDouble(m -> m.getScore()));
		
		Double average = mapStudent.stream()
			.collect(Collectors.averagingDouble(m -> m.getScore()));
		
		rankDTO.setStudentName(student.getName());
		rankDTO.setStudentId(student.getId());
		rankDTO.setTotalScore(totalScore);
		rankDTO.setAverageScore(average);
		
		return rankDTO;
	}

	@Override
	public Map<String,Double> getListScoreByStudentIDYearMonth(Map<String, String> params) {
			MonthlyScoreFilter monthlyScoreFilter = new  MonthlyScoreFilter();
			
			if(params.containsKey(MonthlyScorePropertyFilter.STUDENTID)) {
				monthlyScoreFilter.setAStudentId(params.get(MonthlyScorePropertyFilter.STUDENTID).isBlank() ? 0 : Long.parseLong(params.get("studentId")));
			}
			if(params.containsKey(YEAR)) {
				monthlyScoreFilter.setYear(params.get(YEAR).isBlank() ? 0 : Short.parseShort(params.get(YEAR)));
			}
			if(params.containsKey(MONTH)) {
				monthlyScoreFilter.setMonth(params.get(MONTH).isBlank() ? 0 : Short.parseShort(params.get(MONTH)));
			}
			
			MonthlyScoreSpec monthlyScoreSpec = new MonthlyScoreSpec(monthlyScoreFilter);
			return toListSubjectScore(monthlyScoreRepository.findAll(monthlyScoreSpec));
	}
	
	private Map<String,Double> toListSubjectScore(List<MonthlyScore> monthlyScores) {
			Map<String,Double> listSubjectscore = new HashMap<>();
			monthlyScores.forEach(l->listSubjectscore.put(l.getSubject().getName(),l.getScore()));
			return listSubjectscore;
	}

}
