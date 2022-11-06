package com.piseth.java.school.schoolManagement.service.impl;

import java.time.Month;
import java.time.Year;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.datatype.jsr310.deser.YearDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.YearMonthDeserializer;
import com.piseth.java.school.schoolManagement.dto.MonthlyScoreDTO;
import com.piseth.java.school.schoolManagement.dto.StudentDTO;
import com.piseth.java.school.schoolManagement.dto.SubjectDTO;
import com.piseth.java.school.schoolManagement.exception.ResourceNotFoundException;
import com.piseth.java.school.schoolManagement.model.MonthlyScore;
import com.piseth.java.school.schoolManagement.model.Student;
import com.piseth.java.school.schoolManagement.model.Subject;
import com.piseth.java.school.schoolManagement.repository.ScoreRepository;
import com.piseth.java.school.schoolManagement.repository.StudentRepository;
import com.piseth.java.school.schoolManagement.repository.SubjectRepository;
import com.piseth.java.school.schoolManagement.service.ScoreService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class MonthlyScoreServiceImpl implements ScoreService{

   private final ScoreRepository scoreRepository;

	
	private final StudentRepository studentRepository;
	
	private final ModelMapper modelMapper;
	
	
	private final SubjectRepository subjectRepository;
	@Override
	public MonthlyScoreDTO createScore(MonthlyScoreDTO score, Long id, Long id1) {
		// TODO Auto-generated method stub
		Student st=this.studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student",id));
		Subject sb=this.subjectRepository.findById(id1).orElseThrow(()->new ResourceNotFoundException("Subject", id1));
		MonthlyScore m=this.modelMapper.map(score, MonthlyScore.class);
		m.setStudent(st);
		m.setSubject(sb);
		m.setMonth(Month.NOVEMBER);
		m.setYear(Year.now());
		MonthlyScore save=this.scoreRepository.save(m);
		
		return this.modelMapper.map(save, MonthlyScoreDTO.class);
	}
	@Override
	public List<MonthlyScoreDTO>getStudentById(Long id) {
		Student student = this.studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student", id));
		List<MonthlyScore> byStudent = this.scoreRepository.findByStudent(student);
		List<MonthlyScoreDTO> list = byStudent.stream().map(p->this.modelMapper.map(p, MonthlyScoreDTO.class))
				.collect(Collectors.toList());
		// TODO Auto-generated method stub
		return list;
	}
	@Override
	public List<MonthlyScoreDTO> getSubjectById(Long id1) {
		Subject subject = this.subjectRepository.findById(id1).orElseThrow(()->new ResourceNotFoundException("Subject", id1));
		List<MonthlyScore> findBySubject = this.scoreRepository.findBySubject(subject);
		List<MonthlyScoreDTO> pp = findBySubject.stream().map(s->this.modelMapper.map(s, MonthlyScoreDTO.class))
				.collect(Collectors.toList());
		// TODO Auto-generated method stub
		return pp;
	}
	@Override
	public void deleteScore(Long id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<MonthlyScoreDTO> getScoreList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public MonthlyScore getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public MonthlyScoreDTO update(Long id, MonthlyScoreDTO monthlyScoreDTO) {
		// TODO Auto-generated method stub
		MonthlyScore score = this.scoreRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("MonthlyScore", id));
		score.setMonth(Month.NOVEMBER);
		score.setScore(score.getScore());
		score.setYear(Year.now());
		MonthlyScore save = this.scoreRepository.save(score);
		
		return this.modelMapper.map(save, MonthlyScoreDTO.class);
		
	}

	
	}


