package com.yedam.java.example1;

public class TakeTrans {
	
	public static void main(String[] args) {
		
		Student wana = new Student("wana", 5000);
		Subway subway = new Subway("3호선", 1500);
		Bus bus = new Bus("564", 1250);
		
		wana.take(subway);
		wana.take(bus);
		
		wana.showInfo();
		subway.showInfo();
		bus.showInfo();
	}

}
