package com.springboot.studentmanagementsystem.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.studentmanagementsystem.entity.Student;
import com.springboot.studentmanagementsystem.repository.StudentRepository;
import com.springboot.studentmanagementsystem.service.StudentService;


@Service
public class StudentServiceImplementation implements StudentService{
	
	private StudentRepository studentRepository;
	
	// We are using constructor based "Dependency Injection" here
	// We can also use @autowired, if we don't want to write constructor 
	public StudentServiceImplementation(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}
	
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}

	@Override
	public Student saveStudent(Student student) {
		
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		
		return studentRepository.save(student);
	}
}
