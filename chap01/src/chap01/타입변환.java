package chap01;

/*
 * 데이터타입을 다른 타입으로 변환 : 자동형변환, 강제형변환
 * 
 * 1. 자동형변환
 * 2. 강제형변한
 * 
 * 
 * String <--> 기본데이터형 (int, double)
 */

public class 타입변환 {

	public static void main(String[] args) {

		// 자동형변한
		int a = 100;
		long b = a;
		
		// 강제형변환
		long c = 220000000;
		int d = (int) c;
		
		System.out.println("b = " + b);
		System.out.println("d = " + d);
		
		// 자동형변환
		double e = c;
		
		// 강제형변환
		double f = 5.2;
		long g = (long) f;
		System.out.println("g = " + g);
		
		double h = (double) 10 / 3;
		System.out.println("h = " + h);
		
		
		System.out.println("result = " + (10 + 20));
		System.out.println(10 + 20 + " = result");
		
		
		// int --> String 
		int i = 100;
		String j = String.valueOf(i);
		
		// String --> int
		String k = "100";
		int l = Integer.parseInt(k);
		double n = Double.parseDouble(k);
		
		
		
	}

}
