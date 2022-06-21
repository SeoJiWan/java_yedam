package com.yedam.java.question;

public class VIPCard implements Payment{

	// 필드
	private String name;
	private String grade;
	private double saleRatio;
	private int point;
	private double pointRatio;
	
	
	// 생성자
	public VIPCard() {
		this.name = "VIPCard";
		this.grade = "GOLD";
		this.saleRatio = 0.1;
		this.pointRatio = 0.03;
	}
	

	// 메서드
	@Override
	public int offline(int price) {
		calcPoint(price);
		return price - (int)(price * (Payment.OFFLINE_PAYMENT_RATIO + saleRatio));
	}

	@Override
	public int online(int price) {
		calcPoint(price);
		return price - (int)(price * (Payment.ONLINE_PAYMENT_RATIO + saleRatio));
	}

	@Override
	public int simple(int price) {
		calcPoint(price);
		return price - (int)(price * (Payment.SIMPLE_PAYMENT_RATIO + saleRatio));
	}
	
	// 포인트 적립
	public void calcPoint(int price) {
		point += price * this.pointRatio;
	}

	@Override
	public void showCardInfo() {
		System.out.println("====== 카드 정보 ======");
		System.out.println("카드명      : " + this.name);
		System.out.println("적용 등급    : " + this.grade);
		System.out.println("할인율      : " + this.saleRatio);
		System.out.println("포인트 적릴율 : " + this.pointRatio);
		System.out.println("적립 포인트   : " + this.point);
	}

}
