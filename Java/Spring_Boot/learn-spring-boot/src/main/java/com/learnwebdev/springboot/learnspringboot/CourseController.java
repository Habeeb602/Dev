package com.learnwebdev.springboot.learnspringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	
	@RequestMapping("/courses")
	public List getCourses() {
		return Arrays.asList(
					new Course(1, "Learn Spring Boot", "in28Minutes"),
					new Course(2, "Learn Nodejs/Expressjs", "JohnSmilga.com"),
					new Course(3, "Learn React", "JohnSmilga.com")
				);
		
	}
}
