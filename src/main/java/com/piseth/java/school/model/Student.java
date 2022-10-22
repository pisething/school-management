package com.piseth.java.school.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.piseth.java.school.model.student.subject.StudentSubject;
import lombok.Data;

@Entity
@Data
@Table(name = "students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	@NotNull
	private String name;
	
	private String gender;
	
	private int age;
	
	@JsonIgnore
	@OneToMany(mappedBy = "student",cascade = CascadeType.DETACH)
	private List<StudentSubject> student_Subjects;
	

}
