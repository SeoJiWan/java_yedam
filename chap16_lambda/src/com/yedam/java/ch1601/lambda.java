package com.yedam.java.ch1601;

public class lambda {
	
	public static void main(String[] args) {
		
		// parameter X, return X
		MyFunInterfaceA fa = () -> {
			String str = "hello world 1";
			System.out.println(str);
		};
		fa.methodA();
		
		fa = () -> { System.out.println("hello world 2"); };
		fa.methodA();
		
		fa = () -> System.out.println("hello world 3"); 
		fa.methodA();
		
		System.out.println();
		
		
		// parameter O, return X
		MyFunInterfaceB fb = (int a) -> {
			a = a * 10;
			System.out.println(a);
		};
		fb.methodB(5);
		
//		MyFunInterfaceB fb;
		
		fb = (a) -> { System.out.println(a * 5); };
		fb.methodB(6);
		
		fb = x -> System.out.println(x * 9);
		fb.methodB(4);
		
		System.out.println();
		
		
		// parameter O, return O
		MyFunInterfaceC fc = (int a, int b) -> {
			return a + b;
		};
		System.out.println(fc.methodC(2, 4));
		
		fc = (a, b) -> { return a + b * 3; };
		System.out.println(fc.methodC(4, 4));
		
		fc = (a, b) -> a + b * a;
		System.out.println(fc.methodC(3, 6));
		
		fc = (a, b) -> Math.max(a, b);
		System.out.println(fc.methodC(3, 1));
		
		fc = (a, b) -> Integer.compare(a, b);
		System.out.println(fc.methodC(3, 7));
		
		// 익명 객체 함수와 같은 성격을 가짐
		int val1 = 10;
		int val2 = 20;
		
		// 외부 변수 사용시 메서드 안에서는 final 성격을 가짐
		fa = () -> {
			int result = val1 + val2;
			System.out.println(result);
		};
		
		
		
	}

}
