package com.piseth.java.school.schoolManagement.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.piseth.java.school.schoolManagement.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "monthly_score", uniqueConstraints = @UniqueConstraint(
		columnNames = {"student_id", "subject_id", "year", "month"}))
public class MonthlyScore {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "subject_id")
	private Subject subject;
	
	@Column(name = "score")
	private Double score;
	
	@Column(name = "year")
	private Short year;
	
	@Column(name = "month")
	private Short month;

}
