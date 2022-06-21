package com.yedam.java.example3;

public class CardFactory {
	// 필드
	private static CardFactory cardFactory = new CardFactory();
	
	// 생성자
	private CardFactory() {}
	
	// 메서드
	public static CardFactory getCardFactory() {
		return cardFactory;
	}
	
	public Card createCard(String name) {
		return new Card(name);
	}
}
