package com.yedam.java.ch1202;

public class PrintTread extends Thread {

	// 무한 반복 스레드
	@Override
	public void run() {
		
		// interrupt -> 작업 스레드를 종료시킬 경우
//		try {
//			while (true) {
//				System.out.println("실행중");
//				Thread.sleep(1000);
//			}
//		} catch (InterruptedException e) { 
//			// --> InterruptedException 발생하려면 sleep 이 필요
//			System.out.println("interrupt method 실행");
//		}
//		
//		System.out.println("자원 정리");
//		System.out.println("종료");
		
		// interrupt -> 작업 중 일시적인 추가작업이 필요한 경우
		while (true) {
			System.out.println("실행중");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("interrupt method 실행");
				System.out.println("자원 정리");
				System.out.println("종료");
			}
		}
		
		
	}
	
	

}
