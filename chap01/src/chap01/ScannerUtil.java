package chap01;

import java.util.Scanner;

public class ScannerUtil {
	public static void main(String[] args) {
		
		String name;
		String job;
		int age;
		
		// 문자열 입력
		Scanner sc = new Scanner(System.in);
		
		// 프롬프트 출력
		System.out.print("이름 : ");
		// 문자열 입력받아 변수에 저장
		name = sc.nextLine();
		
		// 프롬프트 출력
		System.out.print("직업 : ");
		// 문자열 입력받아 변수에 저장
		job = sc.nextLine();
		
		// 프롬프트 출력
		System.out.print("나이 : ");
		// 문자열 입력받아 변수에 저장
		age = Integer.parseInt(sc.nextLine());
		
		
		// 입력받은 문자열 출력
		System.out.println();
		System.out.println("####################################");
		System.out.printf("안녕하세요.\n저의 이름은 %s 이고, 직업은 %s, %s세 입니다.", name, job, age);
		System.out.println();
		System.out.println("####################################");
	}

}
