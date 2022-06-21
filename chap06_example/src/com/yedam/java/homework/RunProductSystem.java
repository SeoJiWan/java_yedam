package com.yedam.java.homework;

import java.util.Scanner;

public class RunProductSystem {

	public static void main(String[] args) {

		ProductSystem ps = new ProductSystem();
		Scanner sc = new Scanner(System.in);

		boolean run = true;

		while (run) {
			System.out.println("-----------------------------------------------------");
			System.out.println("1.상품 수 | 2.상품 및 가격입력 | 3.제품별 가격 | 4.분석 | 5.종료");
			System.out.println("-----------------------------------------------------");
			System.out.print("메뉴 선택 >> ");
			int userInput = 0;
			try {
				userInput = Integer.parseInt(sc.nextLine());

				System.out.println();

				if (userInput == 1) {
					System.out.print("상품 수를 입력하세요 : ");
					int size = Integer.parseInt(sc.nextLine());
					System.out.println();
					ps.setProductNum(size);
				}

				else if (userInput == 2) {
					System.out.print("상품을 입력하세요 : ");
					String name = sc.nextLine();

					System.out.print("가격을 입력하세요 : ");
					int price = Integer.parseInt(sc.nextLine());
					System.out.println();

					ps.setProductInfo(name, price);

				}

				else if (userInput == 3) {
					System.out.println("제품별 가격 조회합니다.");
					ps.showProductInfo();
					System.out.println();
				}

				else if (userInput == 4) {
					System.out.println("분석 정보를 조회합니다.");
					ps.analysis();
					System.out.println();
				}

				else if (userInput == 5) {
					System.out.println("프로그램을 종료합니다.");
					break;
				}
				
				else {
					System.out.println("잘못된 입력입니다.");
				}
				
			} catch (NumberFormatException e) {
				System.out.println();
				System.out.println("잘못된 입력입니다.");
				System.out.println();
				
			}
		}
	}

}
