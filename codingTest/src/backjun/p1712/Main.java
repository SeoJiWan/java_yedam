package backjun.p1712;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = sc.nextLong();

		long cnt = 0;

		if (b >= c) {
			cnt = -1;
			System.out.println(cnt);
		}

		else {
			cnt = a / (c - b) + 1;
			System.out.println(cnt);
		} 
	}
}
