package chap01;

import java.util.Scanner;

public class 사각형면적 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 가로 입력
		System.out.print("가로 : ");
		int width = sc.nextInt();
		// 세로 입력
		System.out.print("세로 : ");
		int height = sc.nextInt();
		
		// 면적 계산
		int area = width * height;
		
		// 면적 출력
		System.out.println("면적 = " + area);
		
		System.out.println();
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print("ㅁ ");
			}
			System.out.println();
			
		}
	
	}

}
