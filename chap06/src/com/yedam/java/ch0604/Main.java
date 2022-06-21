package com.yedam.java.ch0604;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		boolean run = true;
		Scanner sc = new Scanner(System.in);
		Program program = new Program();

		while (run) {
			System.out.println("1.학생 수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.print("선택 >> ");
			int userInput = sc.nextInt();
			System.out.println();

			if (userInput == 1) {
				System.out.print("학생 수 >>");
				int studentNum = sc.nextInt();
				program.setStudentNum(studentNum);
				System.out.println();
			}

			else if (userInput == 2) {
				System.out.print("점수 입력 >> ");
				int score = sc.nextInt();
				program.setStudentScore(score);
			}

			else if (userInput == 3) {
				program.printScores();
			}

			else if (userInput == 4) {
				program.analysis();
			}

			else if (userInput == 5) {

			}

			else {
				System.out.println("wrong input");
			}
		}

	}

}
