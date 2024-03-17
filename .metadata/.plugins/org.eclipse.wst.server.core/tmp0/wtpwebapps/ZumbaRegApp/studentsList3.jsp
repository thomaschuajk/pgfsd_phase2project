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
<h2>Students List</h2>
	
	<table border="1">
		<thead>
			<tr>
				<th>Student ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Batch ID</th>
				<th>Start Date</th>
				<th>End Date </th>
				<th>Session Time </th>
				<th>Update</th>				
			</tr>
		</thead>
		<tbody>
		
			<c:forEach var="pair" items="${pairs}">
		                <tr>
		                    <td>${pair.getStudent().getStudentId()}</td>
		                    <td>${pair.getStudent().getFName()}</td>
		                    <td>${pair.getStudent().getLName()}</td>
		                    <td>${pair.getStudent().getEMail()}</td>
		                    <td>${pair.getStudent().getBatchId()}</td>
		                    <td>${pair.getBatch().getStartDate()}</td>
		                    <td>${pair.getBatch().getEndDate()}</td>
		                    <td>${pair.getBatch().getSessionTime()}</td>
		                    <td>
		                        <a href="editstudent?id=${pair.getStudent().getStudentId()}">Edit</a>&nbsp;
		                        <a href="deletestudent?id=${pair.getStudent().getStudentId()}">Delete</a>
		                    </td>
		                </tr>
		     </c:forEach>
		     <a href="studentform">Add Student</a>&nbsp;
		     <a href="index.jsp">Main Page</a>
		     <br><br>
			
		</tbody>
	</table>

</body>
</html>