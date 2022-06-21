package com.yedam.java.test;

import java.util.Scanner;

public class StudentSystem {

	private Student[] list;
	private int idx;

	// 1. 학생 수 입력
	void setStudentNum(int num) {
		list = new Student[num];
	}

	// 학번 중복 확인
	boolean checkDuplicateId(int studentId, int idx) {
		boolean ans = false;
		for (int i = 0; i < idx; i++) {
			if (studentId == list[i].getStudentId()) {
				return ans;
			}
		}
		ans = true;

		return ans;
	}

	// 2. 학생정보 등록
	void setStudentInfo() {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < list.length; i++) {
			int studentId = 0;

			while (true) {
				System.out.print("학번 > ");
				studentId = Integer.parseInt(sc.nextLine());

				// 학번 중복 배제
				boolean checkPoint = checkDuplicateId(studentId, i);
				if (checkPoint == true) {
					break;
				}
				else {
					System.out.println();
					System.out.println("중복된 학번입니다.");
					System.out.println();
					continue;
				}
			}
			
			System.out.print("이름 > ");
			String name = sc.nextLine();

			System.out.print("점수 > ");
			int score = Integer.parseInt(sc.nextLine());

			Student student = new Student(studentId, name, score);
			list[i] = student;
			System.out.println();
		}
	}

	// 3. 학생정보 전체조회
	void checkStudentInfo() {
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i].getStudentId() + " 학번의 점수는 " + list[i].getScore() + "입니다.");
		}
	}

	// 4. 학생정보 분석
	// 최저점을 가진 학생의 정보
	Student findMinInfo() {
		Student minStudentInfo = list[0];
		for (int i = 0; i < list.length; i++) {
			if (minStudentInfo.getScore() > list[i].getScore()) {
				minStudentInfo = list[i];
			}
		}

		return minStudentInfo;
	}

	// 최고점을 가진 학생의 정보
	Student findMaxInfo() {
		Student maxStudentInfo = list[0];
		for (int i = 0; i < list.length; i++) {
			if (maxStudentInfo.getScore() < list[i].getScore()) {
				maxStudentInfo = list[i];
			}
		}
		return maxStudentInfo;
	}

	// 평균 - 1번을 제외한 점수 (소수점 이하 두자리)
	double findAvg() {
		double sum = 0;
		for (Student student : list) {
			sum += student.getScore();
		}

		sum = sum - (findMinInfo().getScore() + findMaxInfo().getScore());
		double avg = sum / (list.length - 2);

		return avg;
	}
}
