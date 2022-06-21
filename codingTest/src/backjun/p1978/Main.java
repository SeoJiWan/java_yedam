package backjun.p1978;

import java.util.Scanner;

public class Main {
	
	static boolean ans;

	static boolean findPrimeNum(int num) {
		for (int j = 2; j <= num; j++) {
			if (j == num) {
				System.out.println("prime number");
				ans = true;
			}
			else if (num % j == 0) {
				ans = false;
				break;
			}
		}
		return ans;
	}
	
	static int run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int answer = 0;
		
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			boolean ans = findPrimeNum(num);
			if (ans == true) {
				answer++;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		int answer = run();
		System.out.println(answer);
	}
}
