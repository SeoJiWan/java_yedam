package com.yedam.java.ch1202;

public class ThreadTest {

	public static void main(String[] args) {

		ThreadA threadA = new ThreadA();
		threadA.start();

		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		threadA.setStop(true);

		System.out.println("-------------------------");

		Thread sub = new Thread() { // 익명 자식 객체

			@Override
			public void run() {
				while (true) {
					if (Thread.interrupted()) {
						break;
					}
					System.out.println("===========실행중");
				}
				System.out.println("==========자원 정리");
				System.out.println("=============종료");
			}
		};

		sub.start();

		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		sub.interrupt();

	}
}
