package com.springbootdemo.myfirstapp.helloworldspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


// Record is a user-defined type, available in java 16
// It creates the getter, setter, hasCode methods by default
record Person(String name, int age, Address address) {}
record Address(String firstLine, String city) {}

@Configuration
public class HelloWorldConfiguration {
	
	@Bean
	public String name(){
		return "Habeeb";
	}
	
	@Bean
	public int age() {
		return 23;
	}
	
	@Bean
	public Person person() {
		var person = new Person("Sumaiya", 27, new Address("123 Main Street", "Eravanchery"));
		return person;
	}
	
	@Bean
	public Address address() {
		return new Address("328/F Kaithe Millath Nagar", "Kumbakonam");
	}
	
	// Giving custom name for bean through annotation
	@Bean (name = "address2")
	@Primary // Returns this bean, if two or more beans of exists with the same type
	public Address address2() {
		return new Address("Rajiv Chowk", "Gurgaon");
	}
	
	// We can also use existing bean inside a another bean
	// Through method call
	@Bean
	public Person personUsingExistingBeanThroughMethodCall() {
		return new Person(name(), age(), address());
	}
	
	// Using existing bean through method parameters
	@Bean ()
	public Person personUsingExistingBeanThroughParameters(int ages, Address address2, String names) {
		System.out.println(names + " " + ages + " " + address2);
		return new Person(names, ages, address2);
	}
	
	
	
	
}

