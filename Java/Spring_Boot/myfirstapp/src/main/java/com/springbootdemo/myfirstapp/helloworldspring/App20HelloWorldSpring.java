package com.springbootdemo.myfirstapp.helloworldspring;


import java.util.*;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App20HelloWorldSpring {
    public static void main(String args[]){
    	
    	try (// Launch a Spring Context
		    	// To launch a spring context, we need the spring context configuration class, so we are creating that
		    	// We need to add @Configuration in that config class
		    	// And inside that config class, we have create a Bean method with @Bean an
		var con = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
			System.out.println(con.getBean("name"));
			System.out.println(con.getBean("age"));
			
			// We are actually printing out the person object here
			// The record type make the toString method customized to the variables we have
			System.out.println(con.getBean("person"));
			System.out.println(con.getBean("address"));
			
			// Using existing bean
			System.out.println(con.getBean("personUsingExistingBeanThroughMethodCall"));
			
			// Another way of using existing bean
			System.out.println(con.getBean("personUsingExistingBeanThroughParameters"));
			
			
			// Accessing bean through Type
			System.out.println(Person.class);
			
			
			
			// Get all the spring beans used by the context
			Arrays.stream(con.getBeanDefinitionNames()).forEach(System.out::println);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    	
    }
}
