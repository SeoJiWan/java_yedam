package backjun.p2480;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] nums = new int[3];
		int[] cnt = new int[6];
		
		for (int i = 0; i < nums.length; i++) {
			nums[i] = sc.nextInt();
		}
		
		for (int i = 0; i < nums.length; i++) {
			cnt[nums[i] - 1] += 1;
		}
		
		for (int i : cnt) {
			System.out.println(i);
		}
		
		int max = cnt[0];
		int maxIdx = 0;
		for (int i = 1; i < cnt.length; i++) {
			if (max < cnt[i]) {
				max = cnt[i];
				maxIdx = i;
			}
		}
		
		int maxNum = nums[0];
		for (int i = 0; i < nums.length; i++) {
			if (maxNum < nums[i]) {
				maxNum = nums[i];
			}
		}
		
		int price = 0;
		if (max == 3) {
			price = 10000 + (maxIdx + 1) * 1000;
		}
		if (max == 2) {
			price = 1000 + (maxIdx + 1) * 100;
		}
		if (max == 1) {
			price = maxNum * 100;
		}
		
		System.out.println(price);
		
	}
}
