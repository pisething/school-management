package com.piseth.java.school.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.piseth.java.school.model.student.subject.StudentSubject;

import lombok.Data;

@Entity
@Data
@Table(name="class")
public class Class {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
     private int id;
     private int grade;
     private String name;
     @JsonIgnore
     @OneToMany(mappedBy = "classStudent")
     private List<StudentSubject> student_Subjects;
     
}
