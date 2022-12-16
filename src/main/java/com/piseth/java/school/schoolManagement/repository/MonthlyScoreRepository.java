package com.piseth.java.school.schoolManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.piseth.java.school.schoolManagement.model.MonthlyScore;

public interface MonthlyScoreRepository
		extends JpaRepository<MonthlyScore, Long>, JpaSpecificationExecutor<MonthlyScore> {

}
