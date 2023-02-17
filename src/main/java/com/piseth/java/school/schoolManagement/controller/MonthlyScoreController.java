package com.piseth.java.school.schoolManagement.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piseth.java.school.schoolManagement.dto.MonthlyScoreDTO;
import com.piseth.java.school.schoolManagement.dto.RankDTO;
import com.piseth.java.school.schoolManagement.dto.StudentDTO;
import com.piseth.java.school.schoolManagement.mapper.MonthlyScoreMapper;
import com.piseth.java.school.schoolManagement.mapper.StudentMapper;
import com.piseth.java.school.schoolManagement.model.MonthlyScore;
import com.piseth.java.school.schoolManagement.model.Student;
import com.piseth.java.school.schoolManagement.service.MonthlyScoreService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/monthlyScores")
@RequiredArgsConstructor
public class MonthlyScoreController {
	private final MonthlyScoreService monthlyScoreService;
	private final MonthlyScoreMapper monthlyScoreMapper;

	@PostMapping
	public ResponseEntity<?> addMonthlyScore(@RequestBody MonthlyScoreDTO monthlyScoreDTO) {
		MonthlyScore monthlyScore = monthlyScoreMapper.toEntity(monthlyScoreDTO);
		System.out.println(">>>>>>>>>>>>>>>>>>"+monthlyScore.toString());
		monthlyScoreService.addMonthlyScore(monthlyScore);
		return ResponseEntity.ok().build();
	}
	@GetMapping("/getMonthlyScore")
	public ResponseEntity<?> getMonthlyScore(@RequestParam Map<String, String> params) {
		List<MonthlyScore> monthlyScores = monthlyScoreService.getMonthlyScore(params,null);
		return ResponseEntity.ok(monthlyScores);
	}
	@GetMapping
	public ResponseEntity<?> getStudentRanks(@RequestParam Map<String, String> params) {
		List<RankDTO> ranks = monthlyScoreService.getRankDTO(params,null);
		return ResponseEntity.ok(ranks);
	}
	
	@GetMapping("/listScore")
	public ResponseEntity<?> listScore(@RequestParam Map<String, String> params) {
		Map<String,Double> listScores = monthlyScoreService.listScores(params,null);
		return ResponseEntity.ok(listScores);
	}
}
