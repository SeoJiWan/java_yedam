package backjun.p3052;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = 42;
		int n = 10;
		int[] remain = new int[n];
		
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			remain[i] = num % a;
		}
		
		Set<Integer> setRemain = new HashSet<Integer>();
		
		for (int i : remain) {
			setRemain.add(i);
		}
		
		System.out.println(setRemain.size());
	}
}
