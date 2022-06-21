package memory;

public class ArrayTest {
	
	public static void main(String[] args) {
		
		int[] momth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		// 2월달의 마지막날은?
		System.out.println("2월달의 마지막날 : " + momth[1]);
		
		String[] week = {"월", "화", "수", "목", "금", "토", "일"};
		
		int[] score = new int[10];
		
		score[0] = 100;
		score = new int[] {1, 2, 3, 4};
		
		for (int i : score) {
			System.out.println(i);
		}
		
	}

}
