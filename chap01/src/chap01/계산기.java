package chap01;

import java.util.Scanner;

/*
 * 작성자 : 서지완
 * 작성일자 : 2022/05-18
 * 기능 : 숫자 계산기
 */
public class 계산기 {

	public static void add() {
		int x = 1;
		int y = 2;
		int result = x + y;
		System.out.println(result);
	}

	public static void sub() {
		int x = 1; // 변수 x를 선언하고 1을 저장.
		int y = 2; // 변수 x를 선언하고 2를 저장.
		int result = x - y; // 변수 result를 선언하고 x와 y를 더한 값을 저장.
		System.out.println(result); // 모니터에 결과를 출력
		
	}
	
	public static void totalAvg() {
		// 국어 변수 선언, 초기화
		int korScore = 90;
		// 영어 변수 선언, 초기화
		int engScore = 97;
		// 수학 변수 선언, 초기화
		int mathScore = 88;
		
		// 세 과목의 합 계산 변수에 담기
		int sum = korScore + engScore + mathScore;
		// 합을 3으로 나누어서 평균을 구해서 담기
		double avg = (double) sum / 3; // 강제 형변환
		
		// 합계 출력
		System.out.println("세 과목 합계 : " + sum);
		// 평균 출력
		System.out.println("세 과목 평균 : " + avg);
	}
	
	

	public static void main(String[] args) {
		// 두 수의 합
//		add();
		// 두 수의 뺄셈
//		sub();
		// 국어, 영어, 수학의 합계와 평균 구하기
		totalAvg();

	}

}
