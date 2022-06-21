package com.yedam.java.chap0901;

public class Outter {
	
	String field = "바깥클래스 - 필드";
	
	void method() {
		System.out.println("바깥클래스 - 메서드");
	}
	
	void methodA() {
		System.out.println("바깥클래스 - 메서드A");
	}
	
	// 인스턴스 멤버 클래스
	class Nested {
		String field = "중첩클래스 - 필드";
		
		void method() {
			System.out.println("중첩클래스 - 메서드");
		}
		
		void print() {
			methodA();
			System.out.println(field);
			method();
			System.out.println(Outter.this.field);
			Outter.this.method();
		}
	}
	
	interface I {
		int FIELD = 100;
		
		void method();
	}
	
	static interface N {
		int FIELD = 100;
		
		void method();
	}

}
