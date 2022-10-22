package com.piseth.java.school.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piseth.java.school.model.student.subject.StudentSubject;

public interface StudentSubjectRepository extends JpaRepository<StudentSubject,Integer> {
//       Optional<StudentSubject> findByClassId(int name);
}
