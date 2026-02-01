package com.learnspringboot.webapp.myfirstwebapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class WelcomeController {

	
	
	
	@GetMapping("/")
	public String welcomePage(ModelMap model) {
		
		model.put("name", getUserName());
		return "welcome";
	}
	
	
	private String getUserName() {
		Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
		
		
}




//	private Logger logger = LoggerFactory.getLogger(getClass());
//logger.debug("My name is {}", name);
//logger.info("Info Level: ", name);
//logger.warn("Warn level: ", name);
//System.out.println("Name: " + name);