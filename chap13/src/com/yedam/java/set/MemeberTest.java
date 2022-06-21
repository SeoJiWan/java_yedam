package com.yedam.java.set;

import java.util.HashSet;
import java.util.Set;

public class MemeberTest {
	
	public static void main(String[] args) {
		
		/*
		 * equals 와 hashcode 메서드 기본 사용 --> 다른 객체로 인식
		 * 
		 * equals 와 hashcode 메서드 오버라이드 (필드가 같으면 true) --> 같은 객체로 인식
		 */
		Set<Member> set = new HashSet<Member>();
		
		set.add(new Member("wana", 1));
		set.add(new Member("wana", 1));
		
		System.out.println("총 객체 : " + set.size());
		
		
	}

}
