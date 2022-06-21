package backjun.p1110;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String strNum = sc.nextLine();
		int cnt = 0;

		while (true) {

			String strNumCp = strNum;
			String first = strNumCp.substring(0, 1);
			String last = strNumCp.substring(1);

//			System.out.println(first);
//			System.out.println(last);

			
			int num = Integer.parseInt(first) + Integer.parseInt(last);
//			System.out.println(newNum);
			String strNum1 = Integer.toString(num);
			if (strNum1.length() == 2) {
				strNum1 = strNum1.substring(1);
			}

			String newStrNum = last + Integer.toString(num);
			
			cnt++;

			if (strNumCp.equals(newStrNum)) {
				break;
			}
		}
		
		System.out.println(cnt);

	}
}
