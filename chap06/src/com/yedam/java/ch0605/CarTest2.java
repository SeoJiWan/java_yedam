package com.yedam.java.ch0605;

public class CarTest2 {
	
	public static void main(String[] args) {
		
		Car firstCar = new Car("singSingCar");
		Car second = new Car("bumperCar");
		
		System.out.println("static field : " + Car.cnt);
		System.out.println("first : " + firstCar.cnt);
		System.out.println("second : " + second.cnt);
		
	}
	

}
