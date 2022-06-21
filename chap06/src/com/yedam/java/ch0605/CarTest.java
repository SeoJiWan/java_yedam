package com.yedam.java.ch0605;

public class CarTest {
	
	public static void main(String[] args) {
		
		Car myCar = new Car("Sportage");
		Car yourCar = new Car("Benz");
		
		myCar.run();
		System.out.println(myCar.speed);
		System.out.println(yourCar.speed);
		yourCar.run();
		
		}

}
