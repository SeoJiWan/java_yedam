package com.yedam.java.example2;

public class StudentSystem {
	
	public static void main(String[] args) {
		
		Student student1 = new Student("Jiwan Seo");
		System.out.println(Student.getSerialNum());
		System.out.println(student1.getName() + " 의 학번 : " + student1.getStudentId());
		System.out.println();
		
		Student student2 = new Student("Changwoo Kim");
		System.out.println(Student.getSerialNum());
		System.out.println(student2.getName() + " 의 학번 : " + student2.getStudentId());
		System.out.println();
		
		Student student3 = new Student("Jaewoong Kim");
		System.out.println(Student.getSerialNum());
		System.out.println(student3.getName() + " 의 학번 : " + student3.getStudentId());
		System.out.println();
		
		System.out.println(student1.getName() + " 의 학번 : " + student1.getStudentId());
		
	}

}
