package com.yedam.java.ch0602;

public class Main2 {
	
	public static void main(String[] args) {
		Car car1 = new Car("Blue");
		
		Car car2 = new Car("Ray" ,"Blue");
		
		Car car3 = new Car("Tivoli", "yello", 120);
		
		System.out.println(car1.model);
		System.out.println(car1.color);
		System.out.println(car1.maxSpeed);
		System.out.println();
		
		System.out.println(car2.company);
		System.out.println(car2.model);
		System.out.println(car2.color);
		System.out.println(car2.maxSpeed);
		System.out.println();

		System.out.println(car3.model);
		System.out.println(car3.color);
		System.out.println(car3.maxSpeed);
		System.out.println();

	}

}
