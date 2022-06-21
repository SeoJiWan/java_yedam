package com.yedam.java.ch1601;

public class ThreadTest {
	
	public static void main(String[] args) {
		Runnable rn = () -> {
			System.out.println("람다식으로 구현");
			for (int i = 1; i <= 5; i++) {
				System.out.println(i);
			}
		};
		
		Thread th1 = new Thread(rn);
		th1.start();
		
		Thread th2 = new Thread(() -> {
			System.out.println("매개변수 -> 람다식");
			for (int i = 1; i <= 5; i++) {
				System.out.println(i * 10);
			}
		});
		th2.start();
	}
	

}
