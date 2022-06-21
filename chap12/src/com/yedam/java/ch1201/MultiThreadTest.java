package com.yedam.java.ch1201;

public class MultiThreadTest {
	
	public static void main(String[] args) {
		
		Thread main = Thread.currentThread(); // 작업하는 정보의 스레드를 가져옴
		System.out.println("메인 스레드 : " + main.getName());
		
//		Thread thread = new Thread(new ThreadA()); // 파라미터로 사용
		
		ThreadB thread = new ThreadB(); // thread 를 상속받아서 사용
		thread.setName("threadB"); // 스레드 이름 변환
		System.out.println("작업 스레드 : " + thread.getName());
		thread.start(); // ThreadA class 작업시작
		
		/*
		 * ThreadB 의 반복문과 main 안의 반복문이 같이 실행
		 * 
		 * ThreadB 가 실행되고 sleep 이 일어나고 다른 스레드인 main 스레드가 실행
		 * main 스레드가 실행되고 sleep 이 일어나고 ThreaB 가 실행 
		 */
		
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
