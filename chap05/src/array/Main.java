package array;

import java.util.Random;
import java.util.Scanner;

public class Main {
	
	public int[] createArr() {
		Random rd = new Random();
		
		// 배열 선언
		int scores[] = new int[10]; // 모든 요소가 0으로 초기화
		
		// 배열 초기화
		for (int i = 0; i < scores.length; i++) {
			scores[i] = rd.nextInt(99) + 1;
		}
		return scores;
	}
	
	
	public void printArr(int[] scores) {
		System.out.print("[");
		for (int i : scores) {
			System.out.print(i + ", ");
		}
		System.out.println("]");
	}
	
	
	public int findMax(int[] scores) {
		int max = scores[0];
		
		for (int i = 1; i < scores.length; i++) {
			
			if (scores[i] > max) {
				max = scores[i];
			}
		}
		
		return max;
	}
	
	
	public int findMin(int[] scores) {
		int min = scores[0];
		
		for (int i = 1; i < scores.length; i++) {
			if (scores[i] < min) {
				min = scores[i];
			}
		}
		return min;
	}
	
	
	public double findAvg(int[] scores) {
		// 평균 구하기
		int sum = 0;
		for (int i : scores) {
			sum += i;
		}
		
		double avg = (double) sum / scores.length;
		
		return avg;
	}
	
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		Main m = new Main();
		int[] scores = m.createArr();

		// 반복문 활용
		while (run) {
			System.out.println("------------------------------------------");
			System.out.println("1.배열출력 | 2.최소값 | 3.최대값 | 4.평균 | 5.종료");
			System.out.println("------------------------------------------");
			System.out.print("선택 >> ");
			int userSelect = sc.nextInt();
			
			System.out.println();
			
			if (userSelect == 1) {
				System.out.println("배열출력입니다.");
				m.printArr(scores);
				System.out.println();
			}
			
			else if (userSelect == 2) {
				System.out.println("최소값을 구합니다.");
				int minNum = m.findMin(scores);
				System.out.println("minNum = " + minNum);
				System.out.println();
			}
			
			else if (userSelect == 3) {
				System.out.println("최대값을 구합니다.");
				int maxNum = m.findMax(scores);
				System.out.println("maxNum = " + maxNum);
				System.out.println();
			}
			
			else if (userSelect == 4) {
				System.out.println("평균을 구합니다.");
				double avgNum = m.findAvg(scores);
				System.out.println("avgNum = " + avgNum);
				System.out.println();
			}
			
			else if (userSelect == 5){
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
			else {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
			
		}
	}
}
