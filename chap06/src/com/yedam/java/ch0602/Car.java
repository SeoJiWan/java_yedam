package com.yedam.java.ch0602;

public class Car {
	
	// 필드
	String company;
	String model;
	String color;
	int maxSpeed;
	
	Car() {
		// TODO Auto-generated constructor stub
	}
	
	Car(String color) {
//		this.color = color;
		this("기아", color);
	}
	
	Car(String model, String color) {
//		this.model = model;
//		this.color = color;
		this("현대", model, color, 350);
	}
	
	Car(String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
	
	Car(String compay, String model, String color, int maxSpeed) {
		this.company = compay;
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}

}
