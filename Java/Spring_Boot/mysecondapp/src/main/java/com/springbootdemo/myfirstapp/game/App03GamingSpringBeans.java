package com.springbootdemo.myfirstapp.game;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.springbootdemo.myfirstapp.game")
public class App03GamingSpringBeans {
	
	
	
	
    public static void main(String args[]){
    	
    	
    	try(var gameRunnerContext = new AnnotationConfigApplicationContext(App03GamingSpringBeans.class)){
    		
    		gameRunnerContext.getBean(GameRunner.class).run();
    		gameRunnerContext.getBean(GamingConsole.class).up();
    		
    		Arrays.stream(gameRunnerContext.getBeanDefinitionNames()).forEach(System.out::println);
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}    	
    }
}


