package com.yedam.java.ch06_hw;

import java.util.Scanner;

public class ScoreAnalysis {
	// 필드
	int[] scoreList;
	
	
	// 생성자
	public ScoreAnalysis() {
		
	}
	
	
	// 메서드
	void setStudentNum(int studentNum) {
		scoreList = new int[studentNum];
	}
	
	void setScore() {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < scoreList.length; i++) {
			System.out.print((i + 1) + " 번째 학생의 점수를 입력하세요 : ");
			scoreList[i] = sc.nextInt();
		}
	}
	
	void selectScore() {
		for (int i = 0; i < scoreList.length; i++) {
			System.out.println(scoreList[i] + " 점");
		}
	}
	
	int findMin() {
		int min = scoreList[0];
		
		for (int i = 1; i < scoreList.length; i++) {
			if (min > scoreList[i]) {
				min = scoreList[i];
			}
		}
		return min;
	}
	
	int findMax() {
		int max = scoreList[0];
		
		for (int i = 1; i < scoreList.length; i++) {
			if (max < scoreList[i]) {
				max = scoreList[i];
			}
		}
		return max;
	}
	
	double avgExceptMinMax() {
		int min = findMin();
		int max = findMax();
		int sum = 0;
		
		for (int i = 0; i < scoreList.length; i++) {
			sum += scoreList[i];
		}
		
		sum -= min + max;
		double avg = (double) sum / (scoreList.length - 2);
		
		return avg;
	}
}
