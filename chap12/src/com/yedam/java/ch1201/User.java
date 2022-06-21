package com.yedam.java.ch1201;

public class User extends Thread{
	
	private static int serial = 0; // -> user1.start() 후 100
	private Calculator calc;
	private int num;
	
	
	public void setCalc(Calculator calc) {
		serial += 100;
		this.setName("User" + serial);
		this.calc = calc;
		this.num = serial;
	}

	@Override
	public void run() {
		calc.setMemory(100 + num);
	}
	
	

}
