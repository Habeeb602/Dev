package com.learnwebdev.springboot.learnjpaandhibernate.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
@Transactional
public class CourseJPARepository {
	
	@Autowired // or we can use 
//	@PersistenceContext
	private EntityManager entityManager;
	
	public void insertCourse(Course course) {
		entityManager.merge(course);
	}
	
	public Course retrieveCourse(int id) {
		return entityManager.find(Course.class, id);
	}
	
	public void deleteCourse(int id) {
		Course course = entityManager.find(Course.class, id);
		entityManager.remove(course);
	}
	
}


