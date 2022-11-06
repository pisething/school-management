package com.piseth.java.school.schoolManagement.score.space;

import java.time.Month;
import java.time.Year;

import lombok.Data;
@Data
public class ScoreFilter {
	private String id;
	private Double score;
	private Year year;
	private Month month;
}
