package com.yedam.java.ch0606.package2;

import com.yedam.java.ch0606.package1.A;

public class C {
	// 필드
	A a1 = new A(true); // public
//	A a2 = new A(1); // default --> error --> 같은 패키지만 가능
//	A a3 = new A("String"); // private --> error --> 같은 클래스만 가능
	
	// 생성자
	public C() {
		A a = new A();
		a.field1 = 1; // public
//		a.field2 = 1; // default --> error --> 같은 패키지만 가능
//		a.field3 = 1; // private --> error --> 같은 클래스만 가능

		a.method1(); // public
//		a.method2(); // default --> error --> 같은 패키지만 가능
//		a.method3(); // private --> error --> 같은 클래스만 가능
	}

}
