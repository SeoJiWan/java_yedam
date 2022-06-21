package com.yedam.java.ch1103;

public class WrapTest {
	
	public static void main(String[] args) {
		
		Integer obj1 = new Integer(100);
		Integer obj2 = Integer.valueOf("100"); // 박싱
		Integer obj3 = 100; // 자동 박싱
		System.out.println(obj1 == obj2);
		System.out.println(obj2 == obj3);
		System.out.println(obj3 == obj1);
		
		int val2 = obj2.intValue(); // 언박싱
		int val3 = obj3; // 자동 언박싱
		System.out.println(val3);
		
		int result = obj2 + obj3;
		
		Integer object1 = 300;
		Integer object2 = 300;
		System.out.println("== 결과 : " + (object1 == object2));
		System.out.println("언박싱 후 == 결과 : " + (object1.intValue() == object2.intValue()));
		System.out.println("equals() 결과 : " + object1.equals(object2)); // 클래스 비교시 좋음
		
	}

}
