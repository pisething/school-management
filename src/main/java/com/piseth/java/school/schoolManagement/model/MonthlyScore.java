package com.piseth.java.school.schoolManagement.model;

import java.time.Month;
import java.time.Year;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name="monthy_score")
public class MonthlyScore {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long Id;
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
	@ManyToOne
	private Student student;

}
