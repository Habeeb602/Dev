package com.springbootdemo.myfirstapp.example.a5;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;



@Component
class ClassA{
	
	private Dependancy someDependancy;
	
	public ClassA(Dependancy someDependancy) {
		this.someDependancy = someDependancy;
		System.out.println("Depandency injected!!!");
	}
	
	@PostConstruct
	public void initialize() {
		someDependancy.depTask();
	}
	
	@PreDestroy
	public void cleanup() {
		System.out.println("Cleanup called");
	}
	
	
}

@Component
class Dependancy{
	public void depTask() {
		System.out.println("Doing dependancy work!!!");
	}
}


@Configuration
@ComponentScan
public class PostPreAnnotationContextApplication {
	
	
	
	
    public static void main(String args[]){
    	
    	
    	try(var gameRunnerContext = new AnnotationConfigApplicationContext(PostPreAnnotationContextApplication.class)){
    		
    		Arrays.stream(gameRunnerContext.getBeanDefinitionNames()).forEach(System.out::println);
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}    	
    }
}


