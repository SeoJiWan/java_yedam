package com.yedam.java.example3;

public class Card {
	// 필드
	private static int serialNum = 1100;
	private int cardNum;
	private String cardName;
	
	// 생성자
	public Card(String name) {
		serialNum++;
		this.cardNum = serialNum;
		this.cardName = name;
	}

	// 메서드
	public static int getSerialNum() {
		return serialNum;
	}
	
	public int getCardNum() {
		return cardNum;
	}

	public String getCardName() {
		return cardName;
	}

	
	
	
	
	
	
	

}
