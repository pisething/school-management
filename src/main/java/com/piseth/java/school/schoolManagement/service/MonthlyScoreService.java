package com.piseth.java.school.schoolManagement.service;

import java.util.List;
import java.util.Map;

import com.piseth.java.school.schoolManagement.dto.RankDTO;
import com.piseth.java.school.schoolManagement.model.MonthlyScore;
import com.piseth.java.school.schoolManagement.spec.MonthlyScoreSpec;

public interface MonthlyScoreService {
	void addMonthlyScore(MonthlyScore monthlyScore);
	
	List<MonthlyScore> getMonthlyScore(Map<String, String> params,MonthlyScoreSpec monthlyScoreSpec);
	
	List<RankDTO> getRankDTO(Map<String, String> params,MonthlyScoreSpec monthlyScoreSpec);
	
	Map<String,Double> listScores(Map<String, String> params, MonthlyScoreSpec monthlyScoreSpec);
}
