package com.yedam.java.ch1601;

public class MainTest {
	
	public static void main(String[] args) {
		// 람다식 이용
//		MyFunctionalInterface fi = () -> { System.out.println("람다식 실행"); };
//		fi.method();
		
		
		// 정석 -> 익명객체함수
		// 인터페이스를 new 연산자로 사용할 경우 익명객체 함수 적용
		MyFunctionalInterface mfi = new MyFunctionalInterface() {
			
			@Override
			public void method() {
				System.out.println("익명 구현 객체 실행");
			}
		};
		
		mfi.method();
	}

}
