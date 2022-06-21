package com.yedam.java.example3;

public class CardSystem {
	
	public static void main(String[] args) {
		CardFactory cardFactory = CardFactory.getCardFactory();
		CardFactory cardFactory1 = CardFactory.getCardFactory();
		CardFactory cardFactory2 = CardFactory.getCardFactory();
		
		Card card1 = cardFactory.createCard("KakaoBank Card");
		System.out.println(card1.getSerialNum());
		System.out.println(card1.getCardName() + " 카드의 번호 : " + card1.getCardNum());
		
		Card card2 = cardFactory.createCard("IBK Card");
		System.out.println(card2.getSerialNum());
		System.out.println(card2.getCardName() + " 카드의 번호 : " + card2.getCardNum());
		
		Card card3 = cardFactory.createCard("Shinhan Card");
		System.out.println(card3.getSerialNum());
		System.out.println(card3.getCardName() + " 카드의 번호 : " + card3.getCardNum());
		
		
		System.out.println(cardFactory);
		System.out.println(cardFactory1);
		System.out.println(cardFactory2); // --> singleton --> 같은 주소 값 참고
	}
}
