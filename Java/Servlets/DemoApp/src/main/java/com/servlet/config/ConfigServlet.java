package com.servlet.config;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfigServlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		ServletConfig config = getServletConfig();
		
		String lang = config.getInitParameter("lang");
		
		res.getWriter().print(lang + " is a great programming language");
		
	}
	
}
