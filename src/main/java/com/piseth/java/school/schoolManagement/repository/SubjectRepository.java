package com.piseth.java.school.schoolManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piseth.java.school.schoolManagement.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
