package com.piseth.java.school.schoolManagement.spec;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.piseth.java.school.schoolManagement.model.Student;

import lombok.AllArgsConstructor;

@SuppressWarnings("serial")
@AllArgsConstructor
public class StudentSpec implements Specification<Student> {
	private StudentFilter studentFilter;

	@Override
	public Predicate toPredicate(Root<Student> student, CriteriaQuery<?> query, CriteriaBuilder cb) {
		List<Predicate> predicates = new ArrayList<>();

		if (studentFilter.getId() != null) {
			Predicate id = student.get("id").in(studentFilter.getId());
			predicates.add(id);
		}
		if (studentFilter.getName() != null) {
			Predicate name = cb.like(student.get("name"), "%"+studentFilter.getName() + "%");
			predicates.add(name);
		}
		if (studentFilter.getGender() != null) {
			Predicate gender = student.get("gender").in(studentFilter.getGender());
			predicates.add(gender);
		}
		return cb.and(predicates.toArray(Predicate[]::new));
	}

}
