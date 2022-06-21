package com.yedam.java.ch0604_01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		boolean run = true;
		Scanner sc = new Scanner(System.in);
		Calculator cal = new Calculator();

		while (run) {
			System.out.println("메뉴 선택 : 1.숫자개수입력 | 2.숫자입력 | 3.더하기 | 4.빼기 | 5.곱하기 | 6.나누기 | 7.종료");
			System.out.print("선택 >> ");
			int userInput = sc.nextInt();
			System.out.println();

			if (userInput == 1) {
				int numOfNum = sc.nextInt();
				cal.setNumsOfNum(numOfNum);
			}

			else if (userInput == 2) {
				int num = sc.nextInt();
				cal.setNums(num);
			}

			else if (userInput == 3) {
				cal.plus();
			}

			else if (userInput == 4) {
				cal.subtract();
			}

			else if (userInput == 5) {
				cal.multiple();
			}

			else if (userInput == 6) {
				cal.devide();
			}
			
			else if (userInput == 7) {
				break;
			}
			
			else {
				System.out.println("wrong");
			}
			System.out.println();

		}

	}

}
