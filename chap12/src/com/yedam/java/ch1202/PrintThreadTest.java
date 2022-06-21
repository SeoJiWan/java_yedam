package com.yedam.java.ch1202;

import java.util.Scanner;

public class PrintThreadTest {
	
	public static void main(String[] args) {
		
//		new PrintTread().start();
		Thread jobThread = new PrintTread();
		jobThread.start();
		
		System.out.println("프로그램 종료하시겠습니까?");
		int result = new Scanner(System.in).nextInt();
		
		if (result != 0) {
			jobThread.interrupt();
		}
	}

}
