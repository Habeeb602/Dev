package com.learnspringboot.restwebservices.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	private MessageSource messageSource;
	
	public HelloWorldController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	@GetMapping("/hello-world")
	public String welcomeString() {
		return "Hello from REST API!!!";
	}
	
	@GetMapping("/hello-world-bean")
	public HelloWorldBean welcomeBean() {
		return new HelloWorldBean("Hello from REST API!!!");
	}
	
	
	// Path parameters
	@GetMapping(path="/hello-world-bean/{name}")
	public HelloWorldBean welcomeBean(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello user, %s", name));
	}
	
	
	@GetMapping("/hello-world/home")
	public String internationalizationWelcomePage() {
		
		Locale locale = LocaleContextHolder.getLocale();
		
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
	}
	
}
