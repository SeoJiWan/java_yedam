package com.yedam.java.chap0902;

public class PersonTest {
	
	public static void main(String[] args) {
		
		Anonymous anonymous = new Anonymous();
		
		// 필드 - 익명 객체
		anonymous.field.wake();
		
		System.out.println();
		
		// 로컬변수 - 익명 객체
		anonymous.method1();
		
		System.out.println();
		
		// 매개변수 - 익명 객체
		anonymous.method2(new Person() {
			// 필드
			String job = "학생";
			
			// 베서드
			void study() {
				System.out.println("공부합니다.");
			}

			@Override
			void wake() {
				System.out.println("10분만...");
				study();
			}
		});
	}
}
