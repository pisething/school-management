package com.piseth.java.school.schoolManagement.dto;

import lombok.Data;

@Data
public class MonthlyScoreDTO {
	private Long subjectId;
	private Double score;
	private Short year;
	private Short month;
}
