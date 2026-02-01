package com.springbootdemo.myfirstapp.example.a3;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.springbootdemo.myfirstapp.example.a1.DepInjLauncherApplication;


@Component
@Lazy
class ClassA{
	
}

@Component
@Lazy
class ClassB{
	ClassA classA;
	public ClassB(ClassA classA) {
		this.classA = classA;
	}
	
	public void doSomething() {
		System.out.println("Doing something");
	}
}






@Configuration
@ComponentScan // If we want the Spring to search for Component in the current file itself
				// Then we don't need to mention the path in @ComponentScan 
public class LazyInitializationLauncherApplication {
	
	
	
	
    public static void main(String args[]){
    	
    	var con = new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class);
    	Arrays.stream(con.getBeanDefinitionNames()).forEach(System.out::println);
//    	con.getBean(ClassB.class).doSomething();
    	
    }
}


