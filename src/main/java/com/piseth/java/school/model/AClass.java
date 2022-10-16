package com.piseth.java.school.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="class")
public class AClass {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
     private int id;
     private int grade;
     private String name;
}
