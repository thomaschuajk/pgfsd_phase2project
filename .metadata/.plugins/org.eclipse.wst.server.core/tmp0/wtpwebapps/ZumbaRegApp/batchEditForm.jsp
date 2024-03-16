<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Update Batch Form</h2>
<form action="batchform" method="post">
		<label for="batchid">Batch Id:</label>
		<input type="text" id="batchid" name="batchid" value="${batch.getStudentId()}" disabled required>
		<br>
		<label for="startdate">Start Date:</label>
		<input type="date" id="startdate" name="startdate" value="${batch.getStartDate()}" required>
		<br>
		<label for="enddate">End Date:</label>
		<input type="date" id="enddate" name="enddate" value="${batch.getEndDate()}" required>
		<br>
		<label for="sessiontime">Session Time:</label>
		<input type="time" id="sessiontime" name="sessiontime" value="${batch.getSessionTime()}" required>
		<br>		
		<input type="submit" value="Submit">
	
	</form>

</body>
</html>