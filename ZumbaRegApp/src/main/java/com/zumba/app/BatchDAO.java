package com.zumba.app;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
//import io.github.cdimascio.dotenv.Dotenv;

public class BatchDAO {
	
	private Connection connection = null;
	private String dbUrl;
	private String dbUser;
	private String dbPassword;
	
	public BatchDAO() {
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
		
	}

	public List<Batch> GetAllBatches(){
		List<Batch> batches = new ArrayList<>();
	
	
		try {
			String query = "SELECT * FROM BATCHES";
			
			try(Statement statement = this.connection.createStatement();
				ResultSet resultSet = statement.executeQuery(query)) {
				
				while(resultSet.next()) {
					Batch batch = new Batch();
					batch.setBatchId(resultSet.getInt("batchId"));
					batch.setStartDate(resultSet.getDate("startDate").toString());
					batch.setEndDate(resultSet.getDate("endDate").toString());
					batch.setSessionTime(resultSet.getTime("sessionTime").toString());
					
					batches.add(batch);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return batches;
	}
	
	public void AddBatch(Batch batch) {
		try {
			
			String query = "INSERT INTO BATCHES (startDate,endDate,sessionTime) VALUES (?,?,?)";
			try(PreparedStatement preparedStatement = this.connection.prepareStatement(query)){
				//batchId is auto-incremented at database
				preparedStatement.setString(1, batch.getStartDate());
				preparedStatement.setString(2,batch.getEndDate());
				preparedStatement.setString(3, batch.getSessionTime());			
							
				preparedStatement.executeUpdate();
			}		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public Batch GetBatchById(int id) {
		Batch batch = new Batch();
		try {
			
			String query = "SELECT * FROM BATCHES";
			try(Statement statement = this.connection.createStatement()){
				ResultSet resultSet = statement.executeQuery(query);
				while(resultSet.next()) {
					if(resultSet.getInt("batchId")==id) {
						batch.setStartDate(resultSet.getDate("startDate").toString());
						batch.setEndDate(resultSet.getDate("endDate").toString());
						batch.setSessionTime(resultSet.getTime("sessionTime").toString());						
						batch.setBatchId(resultSet.getInt("batchId"));
						break;
					}
				}				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return batch;
	}
	
	public void UpdateBatch(Batch batch) {
		try {
			String query = "UPDATE BATCHES SET startDate=?, endDate=?, sessionTime=? WHERE (batchId=?)";
			try(PreparedStatement preparedStatement = this.connection.prepareStatement(query)){
				//System.out.println("Student ID To update: "+student.getStudentId());
				preparedStatement.setDate(1, Date.valueOf(batch.getStartDate()));
				preparedStatement.setDate(2,Date.valueOf(batch.getEndDate()));
				preparedStatement.setTime(3,Time.valueOf(batch.getSessionTime()));
				preparedStatement.setInt(4, batch.getBatchId());

				preparedStatement.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void DeleteStudent(int batchId) {
		try {
			String query = "DELETE FROM BATCHES WHERE (batchId=?)";
			try(PreparedStatement preparedStatement = this.connection.prepareStatement(query)){
				preparedStatement.setInt(1, batchId);		
				preparedStatement.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
