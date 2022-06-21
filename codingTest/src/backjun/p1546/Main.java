package backjun.p1546;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] score = new int[n];
		double[] newScore = new double[n];
		
		double sum = 0;
		
		
		for (int i = 0; i < score.length; i++) {
			score[i] = sc.nextInt();
		}
		
		
		Arrays.sort(score);
		
		int max = score[n - 1];
//		System.out.println("max : " + max);
		
		for (int i = 0; i < n; i++) {
			newScore[i] = (double) score[i] / max * 100;
		}
		
		for (double i : newScore) {
//			System.out.println("i = " + i);
			sum += i;
		}
		
		double avg = sum / n;
		
		System.out.printf("%.2f", avg);
		
		
	}
}
