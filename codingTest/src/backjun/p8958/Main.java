package backjun.p8958;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < n; i++) {
			String str = sc.nextLine();
			String[] strArr = str.split("");
			int[] arr = new int[strArr.length];
			
			if (strArr[0].equals("X")) {
				arr[0] = 0;
			}
			else {
				arr[0] = 1;
			}
			
			for (int j = 1; j < strArr.length; j++) {
				if (strArr[j].equals("X")) {
					arr[j] = 0;
				}
				else {
					arr[j] = 1;
					if (arr[j - 1] != 0) {
						arr[j] = arr[j - 1] + 1;
					}
				}
			}
//			for (int k : arr) {
//				System.out.println(k);
//			}
//			System.out.println();
			int sum = 0;
			for (int k : arr) {
				sum += k;
			}
			
			System.out.println(sum);
			
		}
	}

}
