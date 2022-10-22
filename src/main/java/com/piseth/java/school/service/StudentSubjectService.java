package com.piseth.java.school.service;

import java.util.List;
import com.piseth.java.school.model.student.subject.StudentSubject;

public interface StudentSubjectService {
		 List<StudentSubject> getListStudentSubjects();
         StudentSubject deleteStudentSubject(int id);
         List<StudentSubject> getListStudentByMonth(String month);
         List<StudentSubject> getListStudentFall(String month);
}
