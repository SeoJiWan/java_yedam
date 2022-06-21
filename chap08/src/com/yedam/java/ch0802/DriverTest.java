package com.yedam.java.ch0802;

public class DriverTest {
	
	public static void main(String[] args) {
		
		Driver driver = new Driver();
		driver.drive(new Taxi());
		driver.drive(new Bus());
		
	}

}
