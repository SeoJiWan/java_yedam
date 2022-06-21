package com.yedam.java.test;

public class Student {
	
	private int studentId;
	private String name;
	private int score;
	
	
	public Student(int studentId, String name, int score) {
		this.studentId = studentId;
		this.name = name;
		this.score = score;
	}


	public int getStudentId() {
		return studentId;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}
}
