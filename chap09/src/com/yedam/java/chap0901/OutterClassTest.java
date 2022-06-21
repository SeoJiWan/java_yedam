package com.yedam.java.chap0901;

public class OutterClassTest {

	public static void main(String[] args) {
		
		Outter outter = new Outter();
		
		Outter.Nested nested = outter.new Nested();
		nested.print();
	}
}
