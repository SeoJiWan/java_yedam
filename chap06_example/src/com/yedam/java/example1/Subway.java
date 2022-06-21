package com.yedam.java.example1;

public class Subway {
	private int pay;
	private int money;
	private String lineNumber;
	private int passengerCnt;

	
	public Subway(String lineNumber, int pay) {
		this.lineNumber = lineNumber;
		this.pay = pay;
	}
	
	
	public int getPay() {
		return pay;
	}
	
	public void take(int money) {
		this.money += money;
		this.passengerCnt++;
	}
	
	public void showInfo() {
		System.out.println(lineNumber + " 의 승객은 " + passengerCnt + " 명이고,"
				+ " 수입은 " + money + " 원 입니다.");
		
	}
}
