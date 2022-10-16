package com.piseth.java.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.piseth.java.school.model.AClass;
@Repository
public interface ClassRepository extends JpaRepository<AClass,Integer>{

}
