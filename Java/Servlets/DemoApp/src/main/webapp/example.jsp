<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<!-- Import tag -->    
<%@page import="java.util.*" %>


<!-- Declarative tag -->
<%! int count = 10; %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%
		String s = "I'm a scriplet";
	
	%>


	I'm a print statement, printing <%= count %>.

</body>
</html>