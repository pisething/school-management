package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tblstudent")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
	@Column(name="first_name",nullable = false)
   private String firstName;
	@Column(name="lastName")
   private String lastName;
	@Column(name="subject")
   private String subject;
	@Column(name="score")
   private double score;
}
