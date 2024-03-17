package com.zumba.app;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
//import io.github.cdimascio.dotenv.Dotenv;

public class StudentDAO {
	
	private Connection connection = null;
	private String dbUrl;
	private String dbUser;
	private String dbPassword;
	private BatchDAO _batchDAO;
	
	public StudentDAO() {
		try {
			//Dotenv dotenv = Dotenv.configure().load();
			//this.dbUrl = dotenv.get("DB_URL");
			this.dbUrl = "jdbc:mysql://localhost:3306/zumba_cms";
	        //this.dbUser = dotenv.get("DB_USER");
			this.dbUser ="root";
			this.dbPassword="rootroot";
	        //this.dbPassword = dotenv.get("DB_PASSWORD");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection(this.dbUrl, this.dbUser, this.dbPassword);
			//System.out.println(this.connection);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		this._batchDAO =new BatchDAO();
		
	}

	public List<Student> GetAllStudents(){
		List<Student> students = new ArrayList<>();	
	
		try {
			String query = "SELECT * FROM students";
			
			try(Statement statement = this.connection.createStatement();
				ResultSet resultSet = statement.executeQuery(query)) {
				
				while(resultSet.next()) {
					Student student = new Student();
					student.setStudentId(resultSet.getInt("studentId"));
					student.setFName(resultSet.getString("fName"));
					student.setLName(resultSet.getString("lName"));
					student.setEMail(resultSet.getString("eMail"));
					student.setBatchId(resultSet.getInt("batchId"));
					students.add(student);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return students;
	}
	
	public List<Pair> GetAllStudentsWithBatchDetail(){
		List<Pair> pairs = new ArrayList<>();	
	
		try {
			String query = "select students.studentId, students.fName, students.lName, students.eMail, batches.batchId, batches.startDate, batches.endDate,batches.sessionTime from students join batches on students.batchId = batches.batchId;";
			
			try(Statement statement = this.connection.createStatement();
				ResultSet resultSet = statement.executeQuery(query)) {
				
				while(resultSet.next()) {
					Student student = new Student();
					Batch batch = new Batch();
					student.setStudentId(resultSet.getInt("studentId"));					
					student.setFName(resultSet.getString("fName"));					
					student.setLName(resultSet.getString("lName"));
					student.setEMail(resultSet.getString("eMail"));
					student.setBatchId(resultSet.getInt("batchId"));
					batch.setBatchId(resultSet.getInt("batchId"));
					batch.setStartDate(resultSet.getDate("startDate").toString());
					batch.setEndDate(resultSet.getDate("endDate").toString());					
					batch.setSessionTime(resultSet.getTime("sessionTime").toString());				
					Pair pair = new Pair(student,batch);
					
					pairs.add(pair);					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return pairs;
	}
	
	public void AddStudent(Student student) {
		try {
			
			String query = "INSERT INTO STUDENTS (fName,lName,eMail,batchId) VALUES (?,?,?,?)";
			try(PreparedStatement preparedStatement = this.connection.prepareStatement(query)){
				//StudentId is auto-incremented at database
				preparedStatement.setString(1, student.getFName());
				preparedStatement.setString(2,student.getLName());
				preparedStatement.setString(3, student.getEMail());
				preparedStatement.setInt(4, student.getBatchId());				
				preparedStatement.executeUpdate();
			}		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public Student GetStudentById(int id) {
		Student student = new Student();
		try {
			
			String query = "SELECT * FROM students";
			try(Statement statement = this.connection.createStatement()){
				ResultSet resultSet = statement.executeQuery(query);
				while(resultSet.next()) {
					if(resultSet.getInt("studentId")==id) {
						student.setStudentId(resultSet.getInt("studentId"));
						student.setFName(resultSet.getString("fName"));
						student.setLName(resultSet.getString("lName"));
						student.setEMail(resultSet.getString("eMail"));
						student.setBatchId(resultSet.getInt("batchId"));
						break;
					}
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}
	
	public void UpdateStudent(Student student) {
		try {
			String query = "UPDATE students SET fName=?, lName=?, eMail=?, batchId=? WHERE (studentId=?)";
			try(PreparedStatement preparedStatement = this.connection.prepareStatement(query)){
				//System.out.println("Student ID To update: "+student.getStudentId());
				preparedStatement.setString(1, student.getFName());
				preparedStatement.setString(2,student.getLName());
				preparedStatement.setString(3, student.getEMail());
				preparedStatement.setInt(4, student.getBatchId());
				preparedStatement.setInt(5, student.getStudentId());
				preparedStatement.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void DeleteStudent(int studentid) {
		try {
			String query = "DELETE FROM STUDENTS WHERE (studentId=?)";
			try(PreparedStatement preparedStatement = this.connection.prepareStatement(query)){
				preparedStatement.setInt(1, studentid);		
				preparedStatement.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
