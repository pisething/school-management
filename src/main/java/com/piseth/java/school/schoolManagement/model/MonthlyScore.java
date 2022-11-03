package com.piseth.java.school.schoolManagement.model;

import java.time.Month;
import java.time.Year;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Embeddable
public class MonthlyScore {
	
	@ManyToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;
	
	@Column(name = "score")
	private Double score;
	
	@Column(name = "year")
	private Year year;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "month")
	private Month month;

}
