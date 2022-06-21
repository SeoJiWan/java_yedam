package backjun.p4344;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int c = sc.nextInt();
		
		for (int i = 0; i < c; i++) {
			
			int n = sc.nextInt();
			int[] scores = new int[n];
			
			int sum = 0;
			int avg = 0;
			
			for (int j = 0; j < n; j++) {
				int score = sc.nextInt();
				scores[j] = score;
				sum += score;
			}
			
			avg = sum / n;
			
			int cnt = 0;
			
			for (int j = 0; j < scores.length; j++) {
				if (avg < scores[j]) {
					cnt++;
				}
			}
			
			double ratio = ((double)cnt / (double)scores.length) * 100;
			
			System.out.printf("%.3f%s", ratio, "%");
			System.out.println();
		}
	}
}
