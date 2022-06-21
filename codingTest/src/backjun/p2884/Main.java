package backjun.p2884;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int h = sc.nextInt();
		int m = sc.nextInt();
		
		int newM = m - 45;
		int newH = h;
		
		if (newM < 0) {
			newM = 60 + newM;
			newH = h - 1; 
		}
		
		if (newH < 0) {
			newH = 24 + newH;
		}
		
		System.out.println(newH + " " + newM);
	}
}
