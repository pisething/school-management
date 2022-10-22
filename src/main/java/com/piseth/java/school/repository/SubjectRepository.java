package com.piseth.java.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piseth.java.school.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject,Integer> {

}
