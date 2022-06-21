package com.yedam.java.ch1201;

public class ThreadB extends Thread {

	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("현재 순서 : " + i);
			try {
				Thread.sleep(500); // ms
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	

}
