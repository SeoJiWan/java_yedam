package com.yedam.java.chap0901;

public class MainTest {
	
	public static void main(String[] args) {
		
		A a = new A();
		
		// 중첩클래스 선언
		// 인스턴스 멤버 클래스
		A.B b = a.new B();
		b.field1 = 1;
		b.method1();
		
		
		// 중첩클래스 선언
		// 정적 멤버 클래스
		A.C c = new A.C();
		c.field2 = 2;
		c.method2();
		// 정적 필드, 메서드
		A.C.field3 = 3;
		A.C.method2_1();
		
		
		// 로컬 클래스
		a.method();
		
	}

}
