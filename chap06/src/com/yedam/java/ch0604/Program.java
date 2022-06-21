package com.yedam.java.ch0604;

//1. 학생 수 입력
// 2. 점수 입력
// 3. 점수리스트 출력
// 4. 분석 -> 최고점수, 평균점수
public class Program {

	/*
	 * 필드
	 */
	int[] scores;
	int idx;

	/*
	 * 생성자
	 */
	public Program() {
		idx = -1;
	}
	
	/*
	 * 메서드
	 */
	// 학생 수 입력
	void setStudentNum(int student) {
		scores = new int[student];
	}
	
	// 점수 입력
	void setStudentScore(int score) {
		scores[++idx] = score;
	}
	
	// 전체 출력
	void printScores() {
		for (int i = 0; i < scores.length; i++) {
			System.out.println(scores[i]);
		}
	}
	
	// 분석 --> 최고점수, 평균
	void analysis() {
		int max = scores[0];
		int sum = 0;
		for (int i = 0; i < scores.length; i++) {
			if (max < scores[i]) {
				max = scores[i];
			}
			sum += scores[i];
		}
		int avg = sum / scores.length;
		
		System.out.println("max : " + max + ", avg : " + avg);
	}
	
	
}
