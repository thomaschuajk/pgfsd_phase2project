<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Form</title>
</head>
<body>
	<h2>Student Form</h2>
	
	<form action="studentform" method="post">
		<label for="fname">First Name:</label>
		<input type="text" id="fname" name="fname" required>
		<br>
		<label for="lname">Last Name:</label>
		<input type="text" id="lname" name="lname" required>
		<br>
		<label for="email">Email:</label>
		<input type="email" id="email" name="email" required>
		<br>
		<label for="email">Batch ID:</label>
		<input type="text" id="batchid" name="batchid" required>
		<br>
		<input type="submit" value="Submit">
	
	</form>

</body>
</html>