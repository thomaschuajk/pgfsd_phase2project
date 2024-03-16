package com.zumba.app;

public class Student {
	
	private int studentId;
	private String fName;
	private String lName;
	private String eMail;
	private int batchId;
	
	public int getStudentId() {
		return this.studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getFName() {
		return this.fName;
	}
	public void setFName(String fName) {
		this.fName = fName;
	}
	public String getLName() {
		return this.lName;
	}
	public void setLName(String lName) {
		this.lName = lName;		
	}
	public String getEMail() {
		return this.eMail;
	}
	public void setEMail(String eMail) {
		this.eMail = eMail;
	}
	public int getBatchId() {
		return this.batchId;
	}
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}	

}
