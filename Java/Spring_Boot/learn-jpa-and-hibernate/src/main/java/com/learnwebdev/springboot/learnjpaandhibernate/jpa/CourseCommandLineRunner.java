package com.learnwebdev.springboot.learnjpaandhibernate.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.learnwebdev.springboot.learnjpaandhibernate.jpa.Course;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{

//	@Autowired
//	CourseJPARepository courseJPARepository;
	
	@Autowired
	CourseSpingDataJPARepository courseSpingDataJPARepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * JPA Code
		courseSpingDataJPARepository.insertCourse(new Course(5, "Learn Linux JPA", "in22Minutes"));
		courseSpingDataJPARepository.insertCourse(new Course(3, "Learn Google Cloud JPA", "in22Minutes"));
		courseSpingDataJPARepository.insertCourse(new Course(4, "Learn DevOps JPA", "in22Minutes"));
		
		courseSpingDataJPARepository.deleteCourse(5);
		
		System.out.println(courseSpingDataJPARepository.retrieveCourse(3));
		System.out.println(courseSpingDataJPARepository.retrieveCourse(4));
		
		*/
		
		courseSpingDataJPARepository.save(new Course(5, "Learn Linux Spring Data JPA", "in22Minutes"));
		courseSpingDataJPARepository.save(new Course(3, "Learn Google Cloud Spring Data JPA", "in22Minutes"));
		courseSpingDataJPARepository.save(new Course(4, "Learn DevOps JPA", "Habeeb"));
		
//		courseSpingDataJPARepository.deleteById(5);
		
//		System.out.println(courseSpingDataJPARepository.findById(3));
//		System.out.println(courseSpingDataJPARepository.findById(4));
		
		
		System.out.println(courseSpingDataJPARepository.findByAuthor("Habeeb"));
		System.out.println(courseSpingDataJPARepository.findByName("Learn Linux Spring Data JPA"));
//		courseSpingDataJPARepository.deleteByName("Learn Linux Spring Data JPA");
	
		System.out.println(courseSpingDataJPARepository.findAll());
	}

}
