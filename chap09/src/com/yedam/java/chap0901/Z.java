package com.yedam.java.chap0901;

public class Z {
	
	// 필드
	// 인스턴스 멤버 -> Z 클래스의 인스턴스가 존재
	B field1 = new B(); // Z 클래스의 인스턴스가 존재
	C field2 = new C(); // Z 클래스의 정보만 있으면 됨
	
	void method1() {
		B var1 = new B();
		C var2 = new C();
	}
	
	
	// 정적멤버 -> Z 클래스이 인스턴스가 없을 수 있다.
//	static B field3 = new B(); // 반드시 Z 클래스의 인스턴스가 필요--> 정적으로 사용 불가
	static C field4 = new C(); // Z 클래스의 정보만 필요
	
	static void method2() {
//		B var1 = new B();
		C var2 = new C();
	}
	
	
	// 인스터스 멤버 클래스
	class B {
		
	}
	// 정적 멤버 클래스
	static class C {
		
	}

}
