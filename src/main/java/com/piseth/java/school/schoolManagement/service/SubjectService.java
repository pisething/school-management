package com.piseth.java.school.schoolManagement.service;

import java.util.List;
import java.util.Map;

import com.piseth.java.school.schoolManagement.dto.SubjectDTO;
import com.piseth.java.school.schoolManagement.model.Subject;

public interface SubjectService {
    Subject addSub(Subject subject);
    Subject getById(Long id);
    Subject update(Long id,Subject subject);
    void deleteById(Long id);
    List<Subject> getAllSubject(Map<String,String> param);
}
