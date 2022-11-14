package com.piseth.java.school.schoolManagement.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
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
	private Short year;
	
	@Column(name = "month")
	private Short month;

}
