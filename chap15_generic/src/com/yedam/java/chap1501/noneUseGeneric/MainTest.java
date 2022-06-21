package com.yedam.java.chap1501.noneUseGeneric;

public class MainTest {
	
	public static void main(String[] args) {
		
		Bag bag = new Bag();
		
		bag.set(new Note());
		Note note = (Note) bag.get(); // Object 타입이므로 강제 형변환
		System.out.println(note);
		
		bag.set("서지완");
		String name = (String) bag.get(); // Object 타입이므로 강제 형변환
		System.out.println(name);
	}
}
