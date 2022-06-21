package control;

import java.util.Scanner;

public class ContorlMain {
	
	public static void main(String[] args) {
		
		int score;
		String grade;
		
		do {
			// 등급 계산 조건문
			Scanner sc = new Scanner(System.in);
			score = sc.nextInt();
			
			if (score == 0) {
				break;
			}
			
			if (score >= 90) {
				grade = "A등급";
			}
			
			else if (score >= 80 && score < 90) {
				grade = "B등급";
			}
			
			else if (score >= 70 && score < 80) {
				grade = "C등급";
			}
			
			else if (score >= 60 && score < 70) {
				grade = "D등급";
			}
			
			else {
				grade = "F등급";
			}
			
			System.out.printf("%d 점은 %s 입니다.\n", score, grade);
			
		} while(true);
		
		System.out.println("프로그램 종료");
			
	}

}
