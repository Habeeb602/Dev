package com.learnwebdev.springboot.learnjpaandhibernate.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.learnwebdev.springboot.learnjpaandhibernate.course.Course;

@Repository
public class CourseJDBCRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private String INSERT_QUERY = 
			"""
				INSERT INTO Course (id, name, author)
				VALUES (?,?,?);
			""";
	
	
	private String DELETE_QUERY = 
			"""
				DELETE FROM Course WHERE id = ? ;
			""";
	
	private String SELECT_QUERY = 
			"""
				SELECT * FROM Course WHERE id = ? ;
			""";
	
	
	public void insertCourse(Course course) {
		jdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}
	
	public void deleteCourse(int courseId) {
		jdbcTemplate.update(DELETE_QUERY, courseId);
	}
	
	public Course retrieveCourse(int id) {
		return jdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
	}

}
