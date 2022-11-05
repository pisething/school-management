package com.piseth.java.school.schoolManagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piseth.java.school.schoolManagement.dto.MonthlyScoreDTO;
import com.piseth.java.school.schoolManagement.dto.StudentDTO;
import com.piseth.java.school.schoolManagement.model.MonthlyScore;
import com.piseth.java.school.schoolManagement.service.ScoreService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/score/")
@RequiredArgsConstructor
public class ScoreController {
	private final ScoreService scoreService ;
	@PostMapping("/student/{id}/subject/{id1}")
	public ResponseEntity<MonthlyScoreDTO>createScore(@RequestBody MonthlyScoreDTO score,
		@PathVariable	Long id,
		@PathVariable	Long id1
			){
		//MonthlyScoreDTO student = MonthlyScoreMapper.INSTANCE.toEntity(score);
	MonthlyScoreDTO	student = scoreService.createScore(score, id, id1);
		return new ResponseEntity<MonthlyScoreDTO>(student,HttpStatus.CREATED);
	}
	@GetMapping("/student/{id}/month")
	public ResponseEntity<List<MonthlyScoreDTO>>getStudentScore(@PathVariable Long id){
		List<MonthlyScoreDTO> studentById = this.scoreService.getStudentById(id);
		return new ResponseEntity<List<MonthlyScoreDTO>>(studentById,HttpStatus.OK);
	}
	@GetMapping("/subject/{id1}/subjects")
	public ResponseEntity<List<MonthlyScoreDTO>>getscoreBysubject(@PathVariable Long id1){
		List<MonthlyScoreDTO> subjectById = this.scoreService.getSubjectById(id1);
		return new ResponseEntity<List<MonthlyScoreDTO>>(subjectById,HttpStatus.OK);
	}
	public ResponseEntity<MonthlyScoreDTO>updateScore(@PathVariable Long id,@RequestBody MonthlyScoreDTO monthlyScoreDTO){
		MonthlyScoreDTO update = this.scoreService.update(id, monthlyScoreDTO);
		return new ResponseEntity<MonthlyScoreDTO>(update,HttpStatus.OK);
	}
}
