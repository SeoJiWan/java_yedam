package com.yedam.java.ch1101;

import java.util.Arrays;

public class SystemTest {

	public static void main(String[] args) {
		
		long[] arr = new long[10];

		for (int i = 0; i < 10; i++) {
			long time1 = System.nanoTime();
			int sum = 0;
			for (int j = 1; j < 1000000; j++) {
				sum += j;
			}

			long time2 = System.nanoTime();
//			System.out.println("1 ~ 1000000 까지의 합 : " + sum);
//			System.out.println("계산에 " + (time2 - time1) + " 나노초가 소요.");
			arr[i] = time2 - time1;
		}
		
		Arrays.sort(arr);
		
		System.out.print("[ ");
		for (long l : arr) {
			System.out.print(l + " ");
		}
		System.out.println("]");
		
		System.out.println("최소값 : " + arr[0]);
		System.out.println("최대값 : " + arr[arr.length - 1]);
		
		

	}

}
