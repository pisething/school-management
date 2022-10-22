package com.piseth.java.school.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.piseth.java.school.model.Class;
import com.piseth.java.school.repository.ClassRepository;
import com.piseth.java.school.service.ClassService;
@Service
public class ClassServiceImpl implements ClassService {
	@Autowired
    private ClassRepository classRepository;
	@Override
	public List<Class> getAllClasses() {
		List<Class> aClasses= classRepository.findAll();
		return aClasses;
	}

	@Override
	public void saveAClass(Class classStudents) {
		classRepository.save(classStudents);
	}

	@Override
	public Class deleteClassById(int id) {
		Class aclass = searchClassById(id);
		classRepository.delete(aclass);
		return aclass;
	}


	@Override
	public  Class searchClassById(int id) {
		Optional<Class> aclass = classRepository.findById(id);
		if(aclass.isPresent()) {
			return aclass.get();
		}else {
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND,"Class id = %d can not found !!"+id);
		}
	}

	@Override
	public Class getListStudentByMonth(String className, String month) {
		// TODO Auto-generated method stub
		return null;
	}


}
