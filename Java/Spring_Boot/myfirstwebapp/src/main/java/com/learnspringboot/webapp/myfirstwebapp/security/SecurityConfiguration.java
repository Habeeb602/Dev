package com.learnspringboot.webapp.myfirstwebapp.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfiguration {

	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		
		
		UserDetails userDetails1 = createUser("Habeeb Rahman", "Habeeb");
		UserDetails userDetails2 = createUser("Sumaiya", "Sumaiya");
		

		return new InMemoryUserDetailsManager(userDetails1, userDetails2);
	}

	private UserDetails createUser(String username, String password) {
		Function<String, String> passwordEncoder = input -> pwdEncoder().encode(input);
		UserDetails userDetails = User
				.builder()
				.passwordEncoder(passwordEncoder)
				.username(username)
				.password(password)
				.roles("ADMIN", "USER")
				.build();
		return userDetails;
	}

	@Bean
	public PasswordEncoder pwdEncoder() {
		return new BCryptPasswordEncoder();
	}

}
