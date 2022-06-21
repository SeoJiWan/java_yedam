package backjun.p2581;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	static boolean ans;
	
	static boolean isPrimeNum(int num) {
		for (int j = 2; j <= num; j++) {
			if (j == num) {
				ans = true;
			}
			else if (num % j == 0) {
				ans = false;
				break;
			}
		}
		return ans;
	}
	
	static void run() {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> primeList = new ArrayList<Integer>();
		int startNum = sc.nextInt();
		int endNum = sc.nextInt();
		
		for (int i = startNum; i <= endNum; i++) {
			boolean ans = isPrimeNum(i);
			if (ans == true) {
				primeList.add(i);
			}
		}
		
		if (primeList.size() != 0) {
			Integer min = Collections.min(primeList);
			int sum = primeList.stream().mapToInt(Integer::intValue).sum();
			
			System.out.println(sum);
			System.out.println(min);
		}
		else {
			System.out.println(-1);
		}
		
	}

	public static void main(String[] args) {
		run();
	}
}