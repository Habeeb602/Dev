package com.springbootdemo.myfirstapp.example.a3;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
class Singleton{
	
}


@Component
@Scope (value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class Prototype{
	
}


@Configuration
@ComponentScan
public class BeanScopesLauncherApplication{
	
	public static void main(String args[]) {
		var con =  new AnnotationConfigApplicationContext(BeanScopesLauncherApplication.class);
		
		System.out.println(con.getBean(Singleton.class));
		System.out.println(con.getBean(Singleton.class));
		System.out.println(con.getBean(Singleton.class));
		System.out.println(con.getBean(Singleton.class));
		System.out.println(con.getBean(Singleton.class));
		
		System.out.println();
		
		System.out.println(con.getBean(Prototype.class));
		System.out.println(con.getBean(Prototype.class));
		System.out.println(con.getBean(Prototype.class));
		System.out.println(con.getBean(Prototype.class));
		System.out.println(con.getBean(Prototype.class));
	}
}