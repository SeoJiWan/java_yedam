package com.yedam.java.question;

public interface Payment {
	
	// 필드
	public double OFFLINE_PAYMENT_RATIO = 0.01;
	public double ONLINE_PAYMENT_RATIO = 0.03;
	public double SIMPLE_PAYMENT_RATIO = 0.05;
	
	// 메서드
	int offline(int price);
	
	int online(int price);
	
	int simple(int price);
	
	void showCardInfo();
	

}
