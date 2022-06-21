package com.yedam.java.example1;

public class Student {
	// 필드
	private String name;
	private int money;
	
	// 생성자
	public Student(String name, int money) {
		this.name = name;
		this.money = money;
	}
	
	// 메서드
	public void take(Subway subway) {
		int pay = subway.getPay();
		this.money -= pay;
		subway.take(pay);
	}
	
	// take 메서드 오버로딩
	public void take(Bus bus) {
		int pay = bus.getPay();
		this.money -= pay;
		bus.take(pay);
	}
	
	public void showInfo() {
		System.out.println(name + " 님의 남은 돈은 " + this.money + " 원 입니다.");
	}
	

}
