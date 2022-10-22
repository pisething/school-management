package com.piseth.java.school.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import com.piseth.java.school.model.Subject;
import com.piseth.java.school.repository.SubjectRepository;
import com.piseth.java.school.service.SubjectService;
@Service
public class SubjectServiceImpl implements SubjectService {
     @Autowired
     private SubjectRepository subjectRepository;
	@Override
	public Subject addNew(Subject subject) {
		 Subject sub = getAll()
				 		.stream()
				 		.filter(s->s.getId().equals(subject.getId()))
				 		.findAny()
				 		.orElse(null);
		if( sub!=null) {
			 throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		}
		subjectRepository.save(subject);
		return  subject;
	}
	@Override
	public List<Subject> getAll() {
		return subjectRepository.findAll();
	}

}
