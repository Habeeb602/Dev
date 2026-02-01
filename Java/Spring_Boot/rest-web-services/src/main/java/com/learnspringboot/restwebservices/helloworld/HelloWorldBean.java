package com.learnspringboot.restwebservices.helloworld;

public class HelloWorldBean {
	
	private String message;
	
	HelloWorldBean(String messageString) {
		message = messageString;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}
	
}
