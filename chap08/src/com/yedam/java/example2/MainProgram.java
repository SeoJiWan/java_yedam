package com.yedam.java.example2;

import java.util.Scanner;

public class MainProgram {

	// 필드
	private Scanner sc = new Scanner(System.in);
	private Access access = StudentRepository.getStudentRepository(); // 저장소
	private Program program = new StudentProgram(); // 프로그램

	// 생성자
	public MainProgram() {

		while (true) {
			// 메뉴출력
			program.menuPrint();

			// 메뉴선택
			int menuNo = menuSelect();

			// 각 메뉴실행
			if (menuNo == 1) {
				program.inputInfo(access);
			}

			else if (menuNo == 2) {
				program.printAllInfo(access);
			}

			else if (menuNo == 3) {
				program.printInfo(access);
			}

			else if (menuNo == 4) {
				program.printReport(access);
			}

			else if (menuNo == 5) {
				exit();
				break;
			}
		}
	}

	
	// 메서드
	private int menuSelect() {
		System.out.print("선택 >> ");
		return Integer.parseInt(sc.nextLine());
	}
	
	private void exit() {
		System.out.println("프로그램 종료");
	}

}
