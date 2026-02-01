package com.learnwebdev.springboot.learnjpaandhibernate.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.learnwebdev.springboot.learnjpaandhibernate.course.Course;

@Component
public class JDCBCCommandLineRunner implements CommandLineRunner{

	@Autowired
	private CourseJDBCRepository courseJDBCRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		courseJDBCRepository.insertCourse(new Course(5, "Learn Linux", "in22Minutes"));
		courseJDBCRepository.insertCourse(new Course(3, "Learn Google Cloud", "in22Minutes"));
		courseJDBCRepository.insertCourse(new Course(4, "Learn DevOps", "in22Minutes"));
		
		courseJDBCRepository.deleteCourse(5);
		
		System.out.println(courseJDBCRepository.retrieveCourse(3));
		System.out.println(courseJDBCRepository.retrieveCourse(4));
	}
	
}
