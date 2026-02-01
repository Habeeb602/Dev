package com.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SquareServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		int k = 0;
//		HttpSession session = req.getSession();
//		k = (int) session.getAttribute("k");
		
		
		// Retrieving the value from cookie (using collection)
		List<Cookie> cookies = Arrays.asList(req.getCookies());
		Cookie cookie = cookies.stream().filter(cookiee -> cookiee.getName().equals("k")).findFirst().get();
		k = Integer.parseInt(cookie.getValue());
		 
		 
		
		
		
		int sq = k * k;
		
		res.getWriter().print("Square is " + sq);
		
		
	}
	
}
