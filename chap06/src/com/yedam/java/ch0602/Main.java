package com.yedam.java.ch0602;

public class Main {
	
	public static void main(String[] args) {
		
		Car myCar = new Car();
		System.out.println(myCar.company);
		System.out.println(myCar.model);
		System.out.println(myCar.color);
		myCar.maxSpeed = 100;
		System.out.println(myCar.maxSpeed);
		
		System.out.println();
		
		Car yourCar = new Car();
		System.out.println(yourCar.company);
		System.out.println(yourCar.model);
		System.out.println(yourCar.color);
		System.out.println(yourCar.maxSpeed);

		System.out.println();
		
		Car newCar = new Car("KIA", "Sportage", "white", 240);
		System.out.println(newCar.company);
		System.out.println(newCar.model);
		System.out.println(newCar.color);
		System.out.println(newCar.maxSpeed);
	}

}
