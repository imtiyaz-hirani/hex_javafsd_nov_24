<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.time.*" %>
<%@ page import="java.util.*" %>
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
		
		<hr>
		<p>Welcome <%=request.getAttribute("username") %>   </p>
		
		<h4>Select your fav sports</h4>
		<% 
		   List<String> listSports = (List<String>)	request.getAttribute("list"); 
			
			for(String s : listSports){
		%>
				<p> <%=s %> </p>
		<%
			}
		 %>
		
		<hr>
		<p>Current Date: <%=request.getAttribute("current_date") %> </p> 
		<br>
		 
		<a href="<%=request.getContextPath() %>/welcome-page?username=<%=request.getAttribute("username") %>">Take me to Other Page</a>
		
	</body>
</html>