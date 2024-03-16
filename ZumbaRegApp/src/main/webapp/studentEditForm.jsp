<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Update Student Detail</h2>
	
	<form action="editstudent" method="post">
		<label for="fname">Student Id:</label>
		<input type="text" id="studentid" name="studentid" value="${student.getStudentId()}" disabled required>
		<label for="fname">First Name:</label>
		<input type="text" id="fname" name="fname" value="${student.getFName()}" required>
		<br>
		<label for="lname">Last Name:</label>
		<input type="text" id="lname" name="lname" value="${student.getLName()}" required>
		<br>
		<label for="email">Email:</label>
		<input type="email" id="email" name="email" value="${student.getEMail()}" required>
		<br>
		<label for="email">Batch ID:</label>
		<input type="text" id="batchid" name="batchid" value="${student.getBatchId() }"required>
		<br>
		<input type="submit" value="Update">
	
	</form>


</body>
</html>