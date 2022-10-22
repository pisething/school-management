package com.piseth.java.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.piseth.java.school.model.Class;
@Repository
public interface ClassRepository extends JpaRepository<Class,Integer>{

}
