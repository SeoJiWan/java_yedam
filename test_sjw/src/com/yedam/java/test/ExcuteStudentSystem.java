package com.yedam.java.test;

import java.util.Scanner;

public class ExcuteStudentSystem {

	public static void main(String[] args) {

		StudentSystem studentSystem = new StudentSystem();
		Scanner sc = new Scanner(System.in);

		boolean run = true;

		while (run) {

			try {
				System.out.println("=== 1.학생수 입력  2.학생정보 등록  3.학생정보 전체조회  4.학생정보 분석  5.종료 ===");
				System.out.print("선택 > ");
				int userInput = Integer.parseInt(sc.nextLine());
				System.out.println();

				if (userInput == 1) {
					System.out.print("학생 수 > ");
					int studentNum = Integer.parseInt(sc.nextLine());
					System.out.println();
					
					studentSystem.setStudentNum(studentNum);
				}

				else if (userInput == 2) {
					studentSystem.setStudentInfo();
				}

				else if (userInput == 3) {
					studentSystem.checkStudentInfo();
					System.out.println();
				}

				else if (userInput == 4) {
					Student maxInfo = studentSystem.findMaxInfo();
					System.out.println("최고점수 : " + maxInfo.getScore() + "점, " + "학번 : " + maxInfo.getStudentId());

					Student minInfo = studentSystem.findMinInfo();
					System.out.println("최저점수 : " + minInfo.getScore() + "점, " + "학번 : " + minInfo.getStudentId());

					System.out.printf("최고점, 최저점을 제외한 평균 점수는 %.2f점입니다.", studentSystem.findAvg());
					System.out.println();
					System.out.println();
				}

				else if (userInput == 5) {
					System.out.println("프로그램 종료");
					break;
				}

				else {
					System.out.println("잘못된 입력입니다.");
				}
			} catch (NumberFormatException e) {
				System.out.println("잘못된 입력입니다.");
			}
		}

	}

}
