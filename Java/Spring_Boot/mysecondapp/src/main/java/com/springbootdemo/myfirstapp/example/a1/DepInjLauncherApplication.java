package com.springbootdemo.myfirstapp.example.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;



@Component
class YourBusinessClass{
	
//	@Autowired
	//Dependacy Injection through Fields
	Dependancy1 dependancy1;
	
//	@Autowired
	//Dependacy Injection through Fields
	Dependancy2 dependancy2;
	
	
	
	
	@Autowired
	// For Constructor dependancy injection, we don't need to provide @Autowired
	// It will autowired itself
	public YourBusinessClass(Dependancy1 dependancy1, Dependancy2 dependancy2) {
		super();
		System.out.println("Injecting dependancy through Constructor");
		this.dependancy1 = dependancy1;
		this.dependancy2 = dependancy2;
	}





	/*
	//Dependacy Injection through Setters
	@Autowired
	public void setDependancy1(Dependancy1 dependancy1) {
		System.out.println("Injecting dependancy through Setter method");
		this.dependancy1 = dependancy1;
	}



	@Autowired
	public void setDependancy2(Dependancy2 dependancy2) {
		System.out.println("Injecting dependancy through Setter method");
		this.dependancy2 = dependancy2;
	}


	*/

	public String toString() {
		return "Using " + dependancy1 + " and " + dependancy2;
	}
}


@Component
class Dependancy1{
	
}

@Component
class Dependancy2{
	
}



@Configuration
@ComponentScan // If we want the Spring to search for Component in the current file itself
				// Then we don't need to mention the path in @ComponentScan 
public class DepInjLauncherApplication {
	
	
	
	
    public static void main(String args[]){
    	
    	
    	try(var depInjContext = new AnnotationConfigApplicationContext(DepInjLauncherApplication.class)){
    		
    		Arrays.stream(depInjContext.getBeanDefinitionNames()).forEach(System.out::println);
    		
    		System.out.println(depInjContext.getBean(YourBusinessClass.class));
    		
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}    	
    }
}


