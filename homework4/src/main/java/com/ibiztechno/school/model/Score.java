package com.ibiztechno.school.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "scores")
@Data
public class Score {
	private Integer studentId;
	private Integer subjectId;
	private Double score;
}
