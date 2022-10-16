package com.piseth.java.school.model;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="subjects")
public class Subject {
	@Id
	private Integer id;
	private String name;
	private int score;
	private String month;
	
}
