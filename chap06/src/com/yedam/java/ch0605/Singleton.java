package com.yedam.java.ch0605;

public class Singleton {
	// 필드
	private static Singleton singleton = new Singleton();
	
	// 생성자
	private Singleton() {} // --> 외부에서 new 연산자로 생성 금지
	
	// 메서드
	static Singleton getSingleton() {
		return singleton;
	}

}
