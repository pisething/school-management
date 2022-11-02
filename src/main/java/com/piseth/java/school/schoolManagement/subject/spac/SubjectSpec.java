package com.piseth.java.school.schoolManagement.subject.spac;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.piseth.java.school.schoolManagement.model.Subject;

import lombok.AllArgsConstructor;
@SuppressWarnings("serial")
@AllArgsConstructor
public class SubjectSpec implements Specification<Subject>{
     private SubjectFilter subjectFilter;
	@Override
	public Predicate toPredicate(Root<Subject> subject, CriteriaQuery<?> query, CriteriaBuilder cr) {
		// TODO Auto-generated method stub
		List<Predicate> predicates = new ArrayList<>();
		if(subjectFilter.getId()!=null) {
			Predicate id=subject.get("id").in(subjectFilter.getId());
			predicates.add(id);
			}
		if (subjectFilter.getName() != null) {
			Predicate name = cr.like(subject.get("name"), "%"+subjectFilter.getName() + "%");
			predicates.add(name);
		}
		
		return cr.and(predicates.toArray(Predicate[]::new));
	}

}
