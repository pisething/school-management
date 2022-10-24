package com.student.java.service;

import com.student.java.entity.Student;
import com.student.java.entity.Subject;

import java.util.List;
import java.util.Optional;


public interface StudentService {
    public Student registerStudent(Student student);
    public List<Student> findAll();

    public Optional<Student> getById(final Long id);

    public void removeById(final Long id);

    boolean isExist(Long id);

    public List<Student> getFailStudent();

}
