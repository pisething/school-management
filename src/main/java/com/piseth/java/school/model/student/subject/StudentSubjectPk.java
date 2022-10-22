package com.piseth.java.school.model.student.subject;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Embeddable
@Data
@AllArgsConstructor
public class StudentSubjectPk implements Serializable {
	StudentSubjectPk(){
	}

	@Column(name="student_id")
	private int studentId;
	
	@Column(name="subject_id")
	private int subjectId;
	
}
