package com.springbootdemo.myfirstapp.example.a6;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.springbootdemo.myfirstapp.example.a1.DepInjLauncherApplication;

import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
class Engine{
	
	Piston piston;

	public Piston getPiston() {
		return piston;
	}

	@Inject
	public void setPiston(Piston piston) {
		
		this.piston = piston;
	}
	
	
	
	
}

@Named
class Piston{
	
}


@Configuration
@ComponentScan 
public class CDIContextLauncherApplication {
    public static void main(String args[]){
    	
    	var con = new AnnotationConfigApplicationContext(CDIContextLauncherApplication.class);
    	
    	System.out.println(con.getBean(Engine.class).getPiston());
    	
    }
}


