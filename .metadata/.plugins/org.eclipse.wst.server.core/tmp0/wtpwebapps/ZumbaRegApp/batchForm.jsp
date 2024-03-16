<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Batch Form</h2>
	
	<form action="batchform" method="post">
		<label for="startdate">Start Date:</label>
		<input type="date" id="startdate" name="startdate" required>
		<br>
		<label for="enddate">End Date:</label>
		<input type="date" id="enddate" name="enddate" required>
		<br>
		<label for="sessiontime">Session Time:</label>
		<input type="time" id="sessiontime" name="sessiontime" required>
		<br>		
		<input type="submit" value="Submit">
	
	</form>

</body>
</html>