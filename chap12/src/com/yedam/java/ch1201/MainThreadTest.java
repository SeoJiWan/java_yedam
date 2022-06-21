package com.yedam.java.ch1201;

public class MainThreadTest {
	
	/*
	 * 메인 스레드 안에서는 sleep 이 일어나더라도 한 for문이 다끝나고 다음 for문 진행
	 */
	public static void main(String[] args) {
		
		for (int i = 1; i <= 5; i++) {
			System.out.println("현재 순서 : " + i);
			try {
				Thread.sleep(500); // ms
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for (int i = 1; i <= 5; i++) {
			System.out.println(i + " 번째 출력");
			try {
				Thread.sleep(500); // ms
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
