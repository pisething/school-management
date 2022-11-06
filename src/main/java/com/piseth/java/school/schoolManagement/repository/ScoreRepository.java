package com.piseth.java.school.schoolManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.piseth.java.school.schoolManagement.dto.MonthlyScoreDTO;
import com.piseth.java.school.schoolManagement.model.MonthlyScore;
import com.piseth.java.school.schoolManagement.model.Student;
import com.piseth.java.school.schoolManagement.model.Subject;

public interface ScoreRepository extends JpaRepository<MonthlyScore, Long>,JpaSpecificationExecutor<MonthlyScore> {
  List<MonthlyScore>findByStudent(Student student);
  List<MonthlyScore>findBySubject(Subject subject);
//MonthlyScoreDTO save(MonthlyScoreDTO dto, Integer studentId, Integer subjectId);
//MonthlyScore saveAll(MonthlyScoreDTO dto);
//MonthlyScoreDTO save(MonthlyScoreDTO dto, Long id, Long id1);
//MonthlyScore save(MonthlyScore score, Long id, Long id1);
//MonthlyScore save(MonthlyScore score, Long id, Long id1);
}
