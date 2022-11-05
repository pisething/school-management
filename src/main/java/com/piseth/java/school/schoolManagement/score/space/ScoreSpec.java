package com.piseth.java.school.schoolManagement.score.space;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import com.piseth.java.school.schoolManagement.model.MonthlyScore;
import com.piseth.java.school.schoolManagement.model.Subject;
import com.piseth.java.school.schoolManagement.subject.spac.SubjectFilter;

import lombok.RequiredArgsConstructor;

@SuppressWarnings("serial")
@RequiredArgsConstructor
public class ScoreSpec implements Specification<MonthlyScore>{
	
    private ScoreFilter scoreFilter;
	@Override
	public Predicate toPredicate(Root<MonthlyScore> root, CriteriaQuery<?> query, CriteriaBuilder cr) {
		// TODO Auto-generated method stub
		
			
				// TODO Auto-generated method stub
				List<Predicate> predicates = new ArrayList<>();
//				if(scoreFilter!=null) {
//					Predicate month=root..in(scoreFilter.getId());
//					predicates.add(id);
//					}
				if(scoreFilter.getId()!=null) {
					Predicate id=cr.like(root.get("id"), "%" +scoreFilter.getId()+"%");
					predicates.add(id);
				}
				if (scoreFilter.getScore() != null) {
					Predicate name = cr.like(root.get("score"), "%"+scoreFilter.getScore() + "%");
					predicates.add(name);
				}
				if(scoreFilter.getMonth()!=null) {
					Predicate month=cr.like(root.get("month"),"%"+scoreFilter.getMonth()+"%");
					predicates.add(month);
				}
				if(scoreFilter.getYear()!=null) {
					Predicate year=cr.like(root.get("year"),"%" +scoreFilter.getYear());
					predicates.add(year);
				}
				
		return cr.and(predicates.toArray(Predicate[]::new));
	
	}
}
