package com.yedam.java.ch1103;

public class MathExample {
	
	public static void main(String[] args) {
		
		double v12 = Math.rint(5.3);
		System.out.println("v12 : " + v12);
		
		double v13 = Math.rint(5.5);
		System.out.println("v13 : " + v13);
		
		int random = (int) (Math.random() * 70 + 30);
		System.out.println("random : " + random);
		
		long round = Math.round(5.7);
		System.out.println(round);
		
		int max = Math.max(5, 9);
		System.out.println(max);
		
		System.out.println();
		double val = 12.3456;
		double tmp1 = val * 100;
		System.out.println(tmp1);
		long tmp2 = Math.round(tmp1);
		System.out.println(tmp2);
		double v16 = tmp2 / 100.0;
		System.out.println(v16);
	}
}
