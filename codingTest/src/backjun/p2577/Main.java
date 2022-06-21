package backjun.p2577;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		int num = a * b * c;
		String strNum = Integer.toString(num);
		String[] strArr = strNum.split("");
//		System.out.println(strNum.charAt(0));

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < strArr.length; j++) {
				if (Integer.toString(i).equals(strArr[j])) {
					arr[i]++;
				}
			}
		}

		for (int i : arr) {
			System.out.println(i);
		}

	}
}
