package backjun.p1924;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		String day = "";
		int num = 0;
		
		int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
			
		
			
		if (x == 1) {
			num = y % 7;
			System.out.println("num1 : " + num);
		}
		
		if (x != 1) {
			for (int i = 0; i < x - 1; i++) {
				y += days[i];
			}
			System.out.println("y = " + y);
			num = y % 7;
			System.out.println("num2 : " + num);
			
		}

		switch (num) {
		case 1: day = "MON";
			break;
		case 2: day = "TUE";
			break;
		case 3: day = "WED";
			break;
		case 4: day = "THU";
			break;
		case 5: day = "FRI";
			break;
		case 6: day = "SAT";
			break;
		case 0: day = "SUN";
			break;
		}
		
		System.out.println(day);

	}

}
