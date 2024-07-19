<%@page import="jakarta.servlet.ServletContext"%>
<%@page import="restaurent_management_system.model.entity.Users"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>staffs</title>
</head>
<body>
	<h2><a href="add_staff.jsp">Add Staff</a></h2>
<%
ServletContext context=request.getServletContext();
String message=(String)context.getAttribute("message");
%>
	<h3><%=message %></h3>
	<%
	List<Users> staffs=(List<Users>)request.getAttribute("staffs");
	if(staffs!=null){
		
		%>
		<table>
		<tr>
		<th>ID</th>
		<th>NAME</th>
		<th>EMAIL</th>
		<th>ROLE</th>
		<th>BRANCH ID</th>
		</tr>
		<%
		for(Users s:staffs){
			
		%>
		<tr>
		<th><%=s.getId() %></th>
		<th><%=s.getName() %></th>
		<th><%=s.getEmail() %></th>
		<th><%=s.getRole() %></th>
		<th><%=s.getBranch() %>
		
		<%
		} 
		%>
		</table>
		
	<%}
	else{
	%>
	<h3>No Staff Present..!</h3>
	<%
	}
	%>
	
</body>
</html>