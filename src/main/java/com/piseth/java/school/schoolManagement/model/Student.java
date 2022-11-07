package com.piseth.java.school.schoolManagement.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.piseth.java.school.schoolManagement.enums.Gender;

import lombok.Data;

@Data
@Entity
@Table(name = "students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	private Gender gender;
	
	@ElementCollection
	@CollectionTable(name = "monthly_scores", 
		joinColumns = @JoinColumn(name ="student_id") ,
		uniqueConstraints = @UniqueConstraint(columnNames = {"subject_id", "year", "month"})
	)
	private List<MonthlyScore> monthlyScores;
}
