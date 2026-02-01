package com.springboot.studentmanagementsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.studentmanagementsystem.entity.Student;
import com.springboot.studentmanagementsystem.repository.StudentRepository;



@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {
	
	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
//		Student stud1 = new Student("Habeeb", "Rahman", "habeeb@gmail.com");
//		Student stud2 = new Student("Sumaiya", "Parveen", "sumaiya@gmail.com");
//		Student stud3 = new Student("Nasirah", "M", "nasirah@gmail.com");
//		
//		studentRepository.save(stud1);
//		studentRepository.save(stud2);
//		studentRepository.save(stud3);
//		
		
		
//		studentRepository.deleteAll();
	}

}
