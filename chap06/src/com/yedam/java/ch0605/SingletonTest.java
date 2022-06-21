package com.yedam.java.ch0605;

public class SingletonTest {
	
	public static void main(String[] args) {
		
		Singleton singleton1 = Singleton.getSingleton();
		Singleton singleton2 = Singleton.getSingleton();
		
		if (singleton1 == singleton2) {
			System.out.println("Same singleton obj");
		}
		else {
			System.out.println("Different singleton obj");
		}
		
	}

}
