package com.servlet.config;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		ServletContext ctx = getServletContext();
		
		String name = ctx.getInitParameter("name");
		String age = ctx.getInitParameter("age");
		
		res.getWriter().println("Hi " + name + ", you are " + age + " years old.");
		
		// Context vs Config
		// We get a Config for each Servlets, whereas Context is shared by all the Servlets
		
		
		
	}
	
}
