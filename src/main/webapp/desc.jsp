<%@page import="User_manager.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% 
		User u=(User)session.getAttribute("user"); 
		if(u!=null){
			session.removeAttribute("user");
			response.sendRedirect("login.jsp");
	%>
	<%
		}else{
			response.sendRedirect("login.jsp");
		}
	%>
</body>
</html>