package backjun.p4344;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int c = sc.nextInt();
		int n = sc.nextInt();
		
		for (int i = 0; i < c; i++) {
			
			int sum = 0;
			int avg = 0;
			
			for (int j = 0; j < n; j++) {
				int score = sc.nextInt();
				sum += score;
			}
			
			avg = sum / n;
			
		}
	}

}
