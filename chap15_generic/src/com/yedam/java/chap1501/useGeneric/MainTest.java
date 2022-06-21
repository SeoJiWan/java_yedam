package com.yedam.java.chap1501.useGeneric;

import com.yedam.java.chap1501.noneUseGeneric.Note;

public class MainTest {
	
	public static void main(String[] args) {
		
		// 제네릭 타입 클래스 선언시 타입 지정
		Box<Note, String, Integer> box = new Box<Note, String, Integer>();
		
		box.setT(new Note());
		box.setS("phone");
		box.setK(100);
		
		Note memo = box.getT();
		String inBox = box.getS();
		int num = box.getK();
		
		
		Box<Car, Bus, Taxi> newBox = new Box<Car, Bus, Taxi>();
		Car car = newBox.getT();
		Bus bus = newBox.getS();
		Taxi taxi = newBox.getK();
	}

}

class Car{}

class Bus{}

class Taxi{}