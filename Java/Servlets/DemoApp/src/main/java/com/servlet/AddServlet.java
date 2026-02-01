package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AddServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		int k = i + j;
		
//		res.getWriter().println(k);
//		req.setAttribute("k", k);
		
		
		// We can store the value in the cookies as well
		Cookie cookie = new Cookie("k", String.valueOf(k));
		res.addCookie(cookie);
		System.out.println(LocalDate.of(2018, 5, 21).getDayOfWeek());
		res.sendRedirect("square");
		
		
		
		// We can store the value in the Session variable, and it will persist for the whole session
//		HttpSession session = req.getSession();
//		session.setAttribute("k", k);
//		res.sendRedirect("square");
		
		
		
		
		// Sending values in query string
//		res.sendRedirect("square?k=" + k);
		
		
		
		// This is to redirect/dispatch the control to another servlet 
//		RequestDispatcher rd = req.getRequestDispatcher("square");
//		rd.forward(req, res);
		
//		PrintWriter out = res.getWriter();
//		out.println(i + " + " + j + " = " +k);
	}
}
