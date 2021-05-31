package com.cg.ucaa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ucaa.entities.CourseEntity;

@Repository
public interface ICourseRepository extends JpaRepository<CourseEntity, Long>{
	
}
