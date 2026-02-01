package com.spring.security.springsecurity1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class SpringSecurity1Application {

	@Autowired
	SecurityFilterChain securityFilterChain;


	public static void main(String[] args) {
		SpringApplication.run(SpringSecurity1Application.class, args);
	}

}
