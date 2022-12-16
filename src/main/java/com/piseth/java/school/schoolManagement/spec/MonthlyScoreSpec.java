package com.piseth.java.school.schoolManagement.spec;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;

import com.piseth.java.school.schoolManagement.model.MonthlyScore;
import com.piseth.java.school.schoolManagement.model.Student;
import com.piseth.java.school.schoolManagement.model.Subject;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MonthlyScoreSpec implements Specification<MonthlyScore>{
	private final MonthlyScoreFilter filter;

	@Override
	public Predicate toPredicate(Root<MonthlyScore> monthlyScore, CriteriaQuery<?> query, CriteriaBuilder cb) {
		List<Predicate> predicates = new ArrayList<>();
		
		Join<MonthlyScore, Student> student = monthlyScore.join("student");
		
		if(filter.getGrade() != null) {
			Predicate grade = student.get("grade").in(filter.getGrade());
			predicates.add(grade);
		}
		
		if(filter.getClassName() != null) {
			Predicate className = cb.like(cb.upper(student.get("className")), filter.getClassName().toUpperCase());
			predicates.add(className);
		}
		
		if(!CollectionUtils.isEmpty(filter.getStudentIds()) ) {
			Predicate studentIds = student.get("id").in(filter.getStudentIds());
			predicates.add(studentIds);
		}
		
		if(!CollectionUtils.isEmpty(filter.getSubjectIds()) ) {
			Join<MonthlyScore, Subject> subject = monthlyScore.join("subject");
			Predicate subjectIds = subject.get("id").in(filter.getSubjectIds());
			predicates.add(subjectIds);
		}
		
		if(filter.getYear() != null) {
			Predicate year = monthlyScore.get("year").in(filter.getYear());
			predicates.add(year);
		}
		
		if(filter.getMonth() != null) {
			Predicate month = monthlyScore.get("month").in(filter.getMonth());
			predicates.add(month);
		}
		
		return cb.and(predicates.toArray(Predicate[]::new));
	}

}
