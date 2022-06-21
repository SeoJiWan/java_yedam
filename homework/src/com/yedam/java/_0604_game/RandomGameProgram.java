package com.yedam.java._0604_game;

import java.util.Random;
import java.util.Scanner;

public class RandomGameProgram {

	// 필드
	private Random rd = new Random();
	private Scanner sc = new Scanner(System.in);

	// 생성자
	public RandomGameProgram() {

		// 게임 시작
		Keypad game = runGame();

		while (true) {

			try {
				// 메뉴 출력, 선택
				int selected = menuSelect();

				if (selected == 1) {
					game.leftUpButton();
				} else if (selected == 2) {
					game.leftDownButton();
				} else if (selected == 3) {
					game.rightUpButton();
				} else if (selected == 4) {
					game.rightDownButton();
				} else if (selected == 5) {
					game.changeMode();
				} else if (selected == 0) {
					game = runGame();
				} else if (selected == 9) {
					System.out.println("EXIT");
					break;
				} else {
					System.out.println("잘못된 입력입니다.");
				}
			} 
			catch (NumberFormatException e) {
				System.out.println();
				System.out.println("잘못된 입력입니다.");
			}
		}

	}

	//// 메서드
	// 메뉴 출력
	private int menuSelect() {
		System.out.println();
		System.out.println(
				"=============================================================================================");
		System.out.println(
				"<< 1.LeftUP | 2.LeftDown | 3.RightUp | 4.RightDown | 5.ModeChange | 0.GameChange | 9.EXIT >>");
		System.out.println(
				"=============================================================================================");
		System.out.print("choice >> ");
		int userInput = Integer.parseInt(sc.nextLine());
		System.out.println();

		return userInput;
	}

	// 랜덤 게임 재생
	private Keypad runGame() {
		int randomNum = rd.nextInt(2);

		if (randomNum == 0) {
			return new RPGgame();
		} else {
			return new ArcadeGame();
		}
	}

	// 게임 체인지
	private Keypad changeGame(Keypad keypad) {
		Keypad newGame;
		if (keypad instanceof RPGgame) {
			newGame = new ArcadeGame();
		} else {
			newGame = new RPGgame();
		}
		return newGame;
	}

}
