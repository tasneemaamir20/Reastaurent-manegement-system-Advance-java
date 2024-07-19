<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>homestaff</title>
</head>
<body>
			<h1>Enter staff details</h1>
			<form action="add_staff" method="post">
			Name:<input type="text" name="name"><br>
			Email:<input type="email" name="email"><br>
			Password:<input type="text" name="password"><br>
			<input type="hidden" name="role" value="staff"><br>
			<input type="submit" value="submit">
			
			</form>
	    
</body>
</html>