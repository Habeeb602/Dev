package com.springbootdemo.myfirstapp.example.a2;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.springbootdemo.myfirstapp.example.a1.DepInjLauncherApplication;

@Configuration
@ComponentScan 
public class BusinessLauncherApplication {
	
	
	
	
    public static void main(String args[]){
    	
    	System.out.println("Helllo");
    	var con = new AnnotationConfigApplicationContext(BusinessLauncherApplication.class);
    	Arrays.stream(con.getBeanDefinitionNames()).forEach(System.out::println);
    	System.out.println(con.getBean(BusinessCalculationService.class).findMax());
    }
}


