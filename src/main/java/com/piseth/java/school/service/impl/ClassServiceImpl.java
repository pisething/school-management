package com.piseth.java.school.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import com.piseth.java.school.model.AClass;
import com.piseth.java.school.repository.ClassRepository;
import com.piseth.java.school.service.ClassService;
@Service
public class ClassServiceImpl implements ClassService {
	@Autowired
    private ClassRepository classRepository;
	@Override
	public List<AClass> getAllClasses() {
		List<AClass> aClasses= classRepository.findAll();
		return aClasses;
	}

	@Override
	public void saveAClass(AClass classStudents) {
		classRepository.save(classStudents);
	}

	@Override
	public AClass deleteClassById(int id) {
		AClass aclass = searchClassById(id);
		classRepository.delete(aclass);
		return aclass;
	}


	@Override
	public AClass searchClassById(int id) {
		Optional<AClass> aclass = classRepository.findById(id);
		if(aclass.isPresent()) {
			return aclass.get();
		}else {
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND,"Class id = %d can not found !!"+id);
		}
	}


}
