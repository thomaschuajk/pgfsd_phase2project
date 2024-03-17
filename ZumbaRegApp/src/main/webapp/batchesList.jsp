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
				<th>Batch ID</th>
				<th>Start Date</th>
				<th>End Date</th>
				<th>Session Time</th>				
				<th>Update</th>				
			</tr>
		</thead>
		<tbody>
		
			<c:forEach var="batch" items="${batches}">
		                <tr>
		                    <td>${batch.getBatchId()}</td>
		                    <td>${batch.getStartDate()}</td>
		                    <td>${batch.getEndDate()}</td>
		                    <td>${batch.getSessionTime()}</td>
		                    <td>
		                        <a href="editbatch?id=${batch.getBatchId()}">Edit</a>&nbsp;
		                        <a href="deletebatch?id=${batch.getBatchId()}">Delete</a>
		                    </td>
		                </tr>
		     </c:forEach>
		     <a href="batchform">Create Batch</a>&nbsp;
		     <a href="index.jsp">Main Page</a>
		     <br><br>
			
		</tbody>
	</table>


</body>
</html>