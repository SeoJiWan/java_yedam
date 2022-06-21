package com.yedam.java.chap0901;

public class A {
	
	A() {
		System.out.println("A 인스턴스가 생성됨.");
	}
	
	
	// 중첩 클래스
	// 인스턴스 멤버 클래스
	class B {
		// 필드
		int field1;
		
		
		// 생성자
		B() {
			System.out.println("B 인스턴스가 생성됨.");
		}
		
		
		// 메서드
		void method1() {
			System.out.println("B 클래스 method1");
		}
	}
	
	
	// 정적 멤버 클래스
	static class C {
		// 필드
		int field2;
		static int field3;
		
		
		// 생성자
		C() {
			System.out.println("C 인스턴스가 생성됨.");
		}
		
		
		// 메서드
		void method2() {
			System.out.println("C 클래스 method2");
		}
		
		static void method2_1() {
			System.out.println("C 클래스 정적 method2_1");
		}
	}
	
	
	void method() {
		// 로컬 클래스 -> 메서드 내에 클래스를 정의 --> 메서드 내에서 사용해야함.
		class D {
			// 필드
			int field3;
			
			// 생성자
			D() {
				System.out.println("D 인스턴스가 생성됨.");
			}
			
			// 메서드
			void method3() {
				System.out.println("D 클래스 method3");
			}
		}
		
		D d = new D();
		d.field3 = 3;
		System.out.println(d.field3);
		d.method3();
	}
	

}
