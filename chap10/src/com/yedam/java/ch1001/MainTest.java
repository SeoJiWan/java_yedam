package com.yedam.java.ch1001;

public class MainTest {
	
	public static void main(String[] args) {
		
		// 실행예외
		
		// NullPointerException
		try {
			String data = null;
			System.out.println(data.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
//		// ArrayIndexOutOfBoundException
//		try {
//			String data1 = args[0];
//			String data2 = args[1];
//			System.out.println(data1);
//			System.out.println(data2);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		// NumberFormatException
//		String data1 = "100";
//		String data2 = "a100";
//		
//		int value1 = Integer.parseInt(data1);
//		int value2 = Integer.parseInt(data2);
//		
//		int result = value1 + value2;
		
		// ClassCastException
		changeDog(new Dog());
		changeDog(new Cat());
	}
	
	public static void changeDog(Animal animal) {
		if (animal instanceof Dog) {
			Dog dog = (Dog) animal;
		}
	}

}

class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}
