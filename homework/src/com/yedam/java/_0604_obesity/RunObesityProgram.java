package com.yedam.java._0604_obesity;

public class RunObesityProgram {
	
	public static void main(String[] args) {
		
		Human human1 = new StandardWeightInfo("홍길동", 168, 45);
		human1.getInfo();
		
		Human human2 = new ObesityInfo("박둘이", 168, 90);
		human2.getInfo();
	}
}
