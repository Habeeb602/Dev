package com.learnspringboot.restwebservices.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		// Here we are overriding the default spring-security authentication mechanism
		
		// We are telling that, every request should be authenticated
		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
		
		// This "withDefault()" method, adds a pop-up way of adding authentication.
		http.httpBasic(withDefaults());
		
		//
		http.csrf().disable();
		
		
		return http.build();
	}
	
}
