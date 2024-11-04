<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.time.*" %>
	<!doctype html public "-//w3c/dtd HTML 4.0//en">
<html>
	<body>
		<%!
			int count=5; 
		 %>
		<h2>Welcome to JSP World in 2024, u r 10 years late!! </h2>
		<%-- This is a comment  --%>
		<%  
			out.println(LocalDate.now());
		%>
		<br />
		<p>This week will end on  <%=LocalDate.now().plusDays(5) %>  </p>
		<hr>
		<%
			for(int i=1;i<=count;i++){
		%>
				<span style="font-size="large"><strong> <%=i %> </strong> <span>
		<%	
			}
		%>
	</body>
</html>