package com.yedam.java.map;

import java.util.HashMap;
import java.util.Map;

public class StudentTest {
	
	public static void main(String[] args) {
		
		Map<Student, Integer> map = new HashMap<Student, Integer>();
		
		Student dong = new Student(1, "길동이");
		map.put(dong, 95);
		map.put(dong, 100);
		System.out.println("총 entry 수 : " + map.size());
		System.out.println("학번 : " + dong.sNo + " 이름 : " + dong.name + " 점수 : " + map.get(dong));
		
		map.put(new Student(2, "마동석"), 95);
		map.put(new Student(2, "마동석"), 80);
		System.out.println("총 entry 수 : " + map.size());
		System.out.println("학번 : 2, 이름 : 마동석, 점수 : " + map.get(new Student(2, "마동석")));
		
		Student student2 = new Student(2, "손석구");
		Student student1 = new Student(2, "손석구");
		System.out.println(student1);
		System.out.println(student2);
		
	}

}
