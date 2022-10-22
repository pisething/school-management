package com.piseth.java.school.service;

import java.util.List;

import com.piseth.java.school.model.Class;

public interface ClassService {
       List<Class> getAllClasses();
       void saveAClass(Class classStudents);
       Class deleteClassById(int id);
       Class searchClassById(int id);
       //7. List Range Student
       Class getListStudentByMonth(String className,String month);
       
}
