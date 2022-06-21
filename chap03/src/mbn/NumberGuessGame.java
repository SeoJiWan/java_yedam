package mbn;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// 커밋수정
public class NumberGuessGame {
	
	static int life;
	static int step = 5;

	// game start
	public static void gameStart() {

		// 게임 종료시 user 선택에 따라 재시작 or 종료 결정
		while (true) {
			
			// 키보드 입력
			Scanner sc = new Scanner(System.in);
			// user 가 뽑은 숫자들
			ArrayList<Integer> userDeck = new ArrayList<Integer>();
			// user 에게 주어진 기회
			int chance = 1;
			// 랜덤 숫자 결정
			Random rd = new Random();
			int ans = rd.nextInt(99) + 1;
			// user 목숨 --> 난이도 선택에 활용
			
			/*
			 * 수정 필요
			 */
			// 난이도 선택
			System.out.print("Choose the level (1~5) : ");
			int level = sc.nextInt();
			System.out.println();
			for (int i = 1; i < step + 1; i++) {
				if (level == i) {
					life = (step + 6) - (2 * i) + 1;
				}
			}

			while (chance < life + 1) {

				System.out.print("Please pick the number (1~99)  : ");

				// 유저가 뽑은 숫자
				int userPickNum = sc.nextInt();

				// 유저가 뽑은 숫자가 정답인지 확인
				if (ans == userPickNum) {
					System.out.printf("Congraturation!! %d is correct!\n", ans);
					break;
				}

				// user 가 선택한 숫자가 작을 때
				else if (ans > userPickNum) {

					// user 가 선택한 숫자를 배열에 추가
					userDeck.add(userPickNum);

					System.out.println("Last guess was too low!. Try again!");
					System.out.print("User's pick : ");

					// user 가 선택한 숫자들 출력
					for (int i = 0; i < userDeck.size(); i++) {
						System.out.print(userDeck.get(i) + "    ");
					}

					// 남은 기회 출력
					System.out.print("\nYour Life : ");
					for (int i = 0; i < life - chance; i++) {
						System.out.print("🖤 ");
					}
					for (int i = 0; i < chance; i++) {
						System.out.print("❤ ");
					}
					System.out.println();
					System.out.println();
				}

				// user 가 선택한 숫자가 클 때
				else {
					// user 가 선택한 숫자를 배열에 추가
					userDeck.add(userPickNum);

					System.out.println("Last guess was too high!. Try again!");
					System.out.print("User's pick : ");

					// user 가 선택한 숫자들 출력
					for (int i = 0; i < userDeck.size(); i++) {
						System.out.print(userDeck.get(i) + "    ");
					}

					// 남은 기회 출력
					System.out.print("\nYour Life : ");
					for (int i = 0; i < life - chance; i++) {
						System.out.print("🖤 ");
					}
					for (int i = 0; i < chance; i++) {
						System.out.print("❤ ");
					}
					System.out.println();
					System.out.println();
				}

				chance++;

				if (chance == life + 1) {
					System.out.println("You Died !!!");
				}
			}
			
			System.out.print("\nGame over! retry? ( y(1) | n(0) ) : ");
			
			int retry = sc.nextInt();
			
			if (retry == 1) {
				System.out.println("Restart Game.\n");
				continue;
			}
			else if (retry == 0) {
				System.out.println("Exit Game.");
				break;
			}
		}
	};

	
	
	// main
	public static void main(String[] args) {
		gameStart();

	}

}
