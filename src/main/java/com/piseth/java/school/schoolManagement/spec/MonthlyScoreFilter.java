package com.piseth.java.school.schoolManagement.spec;

import java.util.List;

import lombok.Data;

@Data
public class MonthlyScoreFilter {
	private List<Long> studentIds;
	private List<Long> subjectIds;
	private Short year;
	private Short month;
	private Short grade;
	private String className;
}
