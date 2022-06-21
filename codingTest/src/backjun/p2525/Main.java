package backjun.p2525;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int h = sc.nextInt();
		int m = sc.nextInt();
		int runTime = sc.nextInt();
		
		if (m + runTime >= 60) {
			h += (m + runTime) / 60;
			m = (m + runTime) % 60;
		}
		else {
			m += runTime;
		}
		
		if (h >= 24) {
			h = h - 24;
		}
		
		System.out.println(h + " "  + m);
	}
}
