package com.piseth.java.school.model.student.subject;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.piseth.java.school.model.Class;
import com.piseth.java.school.model.Student;
import com.piseth.java.school.model.Subject;

import lombok.AllArgsConstructor;
import lombok.Data;
@Entity
@Data
@Table(name = "stu_sub")
@AllArgsConstructor
public class StudentSubject {
	    @EmbeddedId
	    StudentSubjectPk id;
		
		@ManyToOne
		@MapsId("studentId")
		@JoinColumn(name = "students_id")
		private Student student;
		
		@ManyToOne 
		@MapsId("subjectId")
		@JoinColumn(name = "subjects_id")
		private Subject subject;
		
		private int score;
		
		private String month;
		
		@ManyToOne
		private Class classStudent;
	
		public StudentSubject(){
			
		}
}
