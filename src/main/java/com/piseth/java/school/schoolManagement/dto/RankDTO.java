package com.piseth.java.school.schoolManagement.dto;

import lombok.Data;

@Data
public class RankDTO {
	private Long studentId;
	private String studentName;
	private Double totalScore;
	private Double averageScore;
	private Integer rank;
}
