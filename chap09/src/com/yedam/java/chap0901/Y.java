package com.yedam.java.chap0901;

public class Y {
	
	// 필드
	int field1;
	static int field2;
	
	// 메서드
	void method1() {}
	static void method2() {}
	
	// 인스턴스 멤버 클래스 -> Y 클래스의 인스턴가 반드시 존재
	//				  -> 인스턴스가 접근할 수 있는 모두 내부 멤버를 호출할 수 있음
	class B {
		void method() {
			field1 = 1;
			field2 = 2;
			
			method1();
			method2();
		}
	}
	
	// 정적 멤버 클래스
	static class C {
		void method() {
//			field1 = 1; // 정적필드가 아니면 사용 불가
			field2 = 2;
			
//			method1(); // 정적메서드가 아니면 사용 불가
			method2();
		}
	}
	
	// 로컬 클래스
	void method(int arg) {
		int var = 1;
//		arg = 100; // 로컬 클래스 내부 변수는 final 성격을 가짐
//		var = 90;
		
		class D {
			void method() {
				int result = arg + var;
			}
		}
		
		D d = new D();
		d.method();
	}

}
