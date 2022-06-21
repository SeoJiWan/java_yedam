package control;

import java.util.Scanner;

/*
 * 0.종료 1.사각형 2.삼각형
 * 
 * 
 * 
 */
public class MenuArea {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int menu;
		String result = null;

		do {
			
			menu = sc.nextInt();
		
			if (menu == 0) {
				System.out.println("Exit Programm");
				break;
			}
			
			else if (menu == 1) {
				result = "사각형";
			}
			
			else if (menu == 2) {
				result = "삼각형";
			}
			
			else {
				System.out.println("잘못된 입력값입니다.");
				continue;
			}
			
			System.out.println("result : " + result);
			
		} while (true);
		
	
	}

}
