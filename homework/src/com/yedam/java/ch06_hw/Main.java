package com.yedam.java.ch06_hw;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ScoreAnalysis sa = new ScoreAnalysis();

		boolean run = true;

		while (run) {
			System.out.println("------------------------------------------------------------------------------------------");
			System.out.println("menu : 1.학생수입력 | 2.점수등록 | 3.점수전체조회 | 4.최소점수 | 5.최대점수 | 6. 평균(최대,최소 제외) | 7.종료");
			System.out.println("------------------------------------------------------------------------------------------");
			System.out.print("선택 >> ");

			int userInput = sc.nextInt();
			System.out.println();

			if (userInput == 1) {
				System.out.print("학생 수를 입력하세요 : ");
				int studentNum = sc.nextInt();
				System.out.println();
				sa.setStudentNum(studentNum);
				
			}

			else if (userInput == 2) {
				sa.setScore();
				System.out.println();
			} 
			
			else if (userInput == 3) {
				sa.selectScore();
				System.out.println();
			}

			else if (userInput == 4) {
				int min = sa.findMin();
				System.out.println("최소 점수 : " + min);
				System.out.println();
			}

			else if (userInput == 5) {
				int max = sa.findMax();
				System.out.println("최대 점수 : " + max);
				System.out.println();
			}

			else if (userInput == 6) {
				double avg = sa.avgExceptMinMax();
				System.out.printf("평균(최대,최소제외) : %.2f%s", avg, " 점");
				System.out.println();
				System.out.println();
			}
			
			else if (userInput == 7) {
				System.out.println("프로그램 종료");
				break;

			}
			
			else {
				System.out.println("잘못된 입력입니다.");
			}

		}
	}

}
