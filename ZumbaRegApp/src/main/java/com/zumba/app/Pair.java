package com.zumba.app;

public class Pair {
	
	Student student;
	Batch batch;
	
	public Pair() {
		
	}
	public Pair(Student student, Batch batch) {		
		this.student = student;
		this.batch = batch;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}
}
