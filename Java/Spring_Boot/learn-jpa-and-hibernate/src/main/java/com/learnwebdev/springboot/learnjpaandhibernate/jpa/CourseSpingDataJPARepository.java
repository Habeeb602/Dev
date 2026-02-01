package com.learnwebdev.springboot.learnjpaandhibernate.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpingDataJPARepository extends JpaRepository<Course, Integer>{
	
	// Making custom methods for customized search
	// The naming convention should be like (findBy<Column-name-with-letter-caps>)
	List<Course> findByAuthor(String author);
	
	List<Course> findByName(String course);
	
	void deleteByName(String course);
}
