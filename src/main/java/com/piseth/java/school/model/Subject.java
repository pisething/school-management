package com.piseth.java.school.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.piseth.java.school.model.student.subject.StudentSubject;
import lombok.Data;

@Data
@Entity
@Table(name="subjects")
public class Subject {
	@Id
	private Integer id;
	private String name;
	@JsonIgnore
	@OneToMany(mappedBy = "subject")
	private List<StudentSubject> student_Subjects;
}
