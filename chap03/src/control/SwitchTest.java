package control;

import java.util.Random;
import java.util.Scanner;

public class SwitchTest {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void test1() {
		
		
//		int menu = sc.nextInt();
//		char menu = sc.next().charAt(0);
		String menu = sc.next();
		
		switch (menu) {
		case "a":
			System.out.println(1);
			break;
		case "b":
			System.out.println(2);
			break;
		case "c":
			System.out.println(3);
			break;
		default:
			System.out.println("기타");
		}
	}
	
	public static void test2() {
		
		int menu = sc.nextInt();
		// 1~5 : 평일, 6~7 : 주말
		
		switch (menu) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			System.out.println("평일");
			break;
		case 6:
		case 7:
			System.out.println("주말");
			break;
		default:
			System.out.println("1~7 입력");
			break;
		}
	}
	
	public static void test3() {
		
		int score = sc.nextInt();
		
		switch (score / 10) {
		case 10:
		case 9:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		case 6:
			System.out.println("D");
			break;
		default:
			System.out.println("F");
			break;
		}
		
	}
	
	public static void main(String[] args) {
		
//		test1();
//		test2();
		test3();
	}

}
