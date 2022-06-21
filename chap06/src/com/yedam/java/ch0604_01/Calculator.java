package com.yedam.java.ch0604_01;

/*
 * 1. 숫자 개수 입력
 * 2. 숫자 입력
 * 3. 더하기
 * 4. 빼기
 * 5. 곱하기
 * 6. 나누기
 */
public class Calculator {
	
	int[] nums;
	int idx;
	
	public Calculator() {
		idx = -1;
	}
	
	
	void setNumsOfNum(int num) {
		nums = new int[num];
	}
	
	void setNums(int num) {
		if (idx < nums.length) {
			nums[++idx] = num;
		}
		else {
			System.out.println("Out of length");
		}
	}
	
	boolean isExecuted() {
		if (idx + 1 < 2) {
			System.out.println("Add number please");
			return false;
		}
		else {
			return true;
		}
	}
	
	void plus() {
		int sum = 0;
		if (isExecuted()) {
			for (int i = 0; i <= idx; i++) {
				sum += nums[i];
			}
			System.out.println("모두 더한 결과 : " + sum);
		}
		
	}
	
	void subtract() {
		int sum = nums[0];
		if (isExecuted()) {
			for (int i = 1; i <= idx; i++) {
				sum -= nums[i];
			}
			System.out.println("모두 뺀 결과 : " + sum);
		}
	}
	
	void multiple() {
		int sum = nums[0];
		if (isExecuted()) {
			for (int i = 1; i <= idx; i++) {
				sum *= nums[i];
			}
			System.out.println("모두 곱한 결과 : " + sum);
		}
	}
	
	void devide() {
		double sum = (double)nums[0];
		if (isExecuted()) {
			for (int i = 1; i <= idx; i++) {
				if (nums[i] != 0) {
					sum /= (double)nums[i];
				}
				else {
					System.out.println("Not devide by zero");
				}
			}
			System.out.println("모두 나눈 결과 : " + sum);
		}
	}
	
	

}
