package com.yedam.java.ch1201;

public class Calculator {
	
	private int memory;

	
	public int getMemory() {
		return memory;
	}

	// synchronized --> 동기화 메서드
	public synchronized void setMemory(int memory) {
		this.memory = memory;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
		}
		Thread info = Thread.currentThread();
		System.out.println("현재 스레드 : " + info.getName() + ", memory : " + this.memory);
	}
	
	
	

}
