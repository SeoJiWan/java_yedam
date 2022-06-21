package control;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WhileTest {

	public static void while1() {
		int cnt = 1;

		do {
			System.out.println(cnt);
			cnt++;
			if (cnt >= 10) {
				break;
			}

		} while (true);
	}

	public static void for1() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + "반복");
		}
	}

	public static void for2() {
		for (int i = 10; i > 0; i--) {
			System.out.println("i = " + i);
		}
	}

	// 구구단 5단 출력
	public static void gugdan_5() {
		for (int i = 1; i < 11; i++) {
			System.out.printf("5 x %d = %d", i, 5 * i);
			System.out.println();
		}
	}

	// 최대값 출력
	public static void findMax() throws FileNotFoundException {

		Scanner sc = new Scanner(new File("C:\\Users\\admin\\eclipse-workspace\\chap03\\src\\score.txt"));
		int n = 10;
		int max = 0;

		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			if (num > max) {
				max = num;
			}
		}
		System.out.println("max = " + max);
	}

	// 최소값 출력
	public static void findMin() throws FileNotFoundException {

		Scanner sc = new Scanner(new File("C:\\Users\\admin\\eclipse-workspace\\chap03\\src\\score.txt"));
		int n = 10;
		int min = sc.nextInt();

		for (int i = 0; i < n - 1; i++) {
			int num = sc.nextInt();
			if (num < min) {
				min = num;
			}
		}
		System.out.println("min = " + min);
	}

	// 최대, 최소값 출력
	public static void findMinMax() throws FileNotFoundException {

		Scanner sc = new Scanner(new File("C:\\Users\\admin\\eclipse-workspace\\chap03\\src\\score.txt"));
		int n = 10;
		int min = sc.nextInt();
		int max = min;

		for (int i = 0; i < n - 1; i++) {
			int num = sc.nextInt();
			if (num < min) {
				min = num;
			}
			if (num > max) {
				max = num;
			}
		}
		System.out.println("max = " + max);
		System.out.println("min = " + min);
	}

	public static void main(String[] args) throws FileNotFoundException {
//		for1();
//		for2();
//		gugdan_5();
		findMax();
		findMin();
	}
}
