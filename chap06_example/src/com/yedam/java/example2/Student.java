package com.yedam.java.example2;

public class Student {
	// 필드
	private static int serialNum = 1000;
	private int studentId; // 학번
	private String name;
	
	// 생성자
	public Student(String name) {
		serialNum++;
		this.studentId = serialNum;
		this.name = name;
	}
	
	// 메서드
	public static int getSerialNum() {
		return serialNum;
	}
	
	public int getStudentId() {
		return studentId;
	}
	
	public String getName() {
		return name;
	}

}
