package com.piseth.java.school.repository;

import  org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.piseth.java.school.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
  
}
