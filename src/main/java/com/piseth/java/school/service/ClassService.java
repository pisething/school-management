package com.piseth.java.school.service;

import java.util.List;
import com.piseth.java.school.model.AClass;

public interface ClassService {
       List<AClass> getAllClasses();
       void saveAClass(AClass classStudents);
       AClass deleteClassById(int id);
       AClass searchClassById(int id);
       
}
