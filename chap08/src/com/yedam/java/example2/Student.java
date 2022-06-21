package com.yedam.java.example2;

public class Student {
	
	// 필드
	private int studentId;
	private String studentName;
	private int studentScore;
	
	
	// 생성자
	public Student() {}

	public Student(int studentId, String studentName, int studentScore) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentScore = studentScore;
	}

	
	// 메서드
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentScore() {
		return studentScore;
	}

	public void setStudentScore(int studentScore) {
		this.studentScore = studentScore;
	}
	
	public void showInfo() {
		System.out.println("학번 : " + this.studentId + ", 이름 : " + this.studentName + ", 점수 : " + this.studentScore);
	}

	
	
	
	
}
