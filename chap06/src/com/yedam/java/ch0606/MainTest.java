package com.yedam.java.ch0606;

import com.yedam.java.ch0605.Car;

public class MainTest {
	
	public static void main(String[] args) {
		Car car = new Car("ssingssingCar");
		String model = car.model;
		System.out.println(model);
		car.run();
		
	}

}
