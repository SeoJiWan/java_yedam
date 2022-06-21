package com.yedam.java.ch1101;

public class ObjectTest {
	
	public static void main(String[] args) {
		Object object1 = new Object();
		Object object2 = new Object();
		
		if (object1.equals(object2)) {
			System.out.println("object1, object2 는 논리적으로 동등");
		}
		
		if (object1 == object2) {
			System.out.println("object1, object2 는 논리적으로 동등");
		}
		

		Member member1 = new Member("123");
		Member member2 = new Member("123");
		Member member3 = new Member("123456");
		
		
		if (member1.equals(member2)) {
			System.out.println("m1 == m2");
		}
		if (member1.equals(member3)) {
			System.out.println("m1 == m3");
		}
		if (member2.equals(member3)) {
			System.out.println("m2 == m3");
		}

	}

}
