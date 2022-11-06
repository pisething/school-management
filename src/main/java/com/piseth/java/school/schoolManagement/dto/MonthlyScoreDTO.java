package com.piseth.java.school.schoolManagement.dto;

import java.time.Month;
import java.time.Year;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Data;

@Data
public class MonthlyScoreDTO {

	private Long id;

	private Double score;
	
	
	private Year year;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "month")
	private Month month;
}
