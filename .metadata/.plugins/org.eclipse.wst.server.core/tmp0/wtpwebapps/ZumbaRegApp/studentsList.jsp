<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import ="com.zumba.app.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Students List</title>
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
			</tr>
		</thead>
		<tbody>
		
		<% List<Student> students = (List<Student>) request.getAttribute("students");%>
			<% for(int i=0; i<students.size();i++){%>
			<tr>			
				
				<td><%=students.get(i).getStudentId() %></td>
                <td><%=students.get(i).getFName()%></td>
                <td><%=students.get(i).getLName() %></td>
                <td><%=students.get(i).getEMail() %></td>
                <td><%=students.get(i).getBatchId()%></td>
                <td>
                    <a href="editStudent?id=${students.get(i).getStudentId()}">Edit</a>
                    <a href="deleteStudent?id=${students.get(i).getStudentId()}">Delete</a>
                </td>
			</tr>
			<%}%>
			
		</tbody>
	</table>

</body>
</html>