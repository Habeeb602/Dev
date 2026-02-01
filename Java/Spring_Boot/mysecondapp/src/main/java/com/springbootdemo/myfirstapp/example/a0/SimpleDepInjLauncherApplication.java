package com.springbootdemo.myfirstapp.example.a0;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.springbootdemo.myfirstapp.example.a1.DepInjLauncherApplication;

@Configuration
@ComponentScan // If we want the Spring to search for Component in the current file itself
				// Then we don't need to mention the path in @ComponentScan 
public class SimpleDepInjLauncherApplication {
	
	
	
	
    public static void main(String args[]){
    	
    	
    	try(var gameRunnerContext = new AnnotationConfigApplicationContext(SimpleDepInjLauncherApplication.class)){
    		
    		Arrays.stream(gameRunnerContext.getBeanDefinitionNames()).forEach(System.out::println);
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}    	
    }
}


