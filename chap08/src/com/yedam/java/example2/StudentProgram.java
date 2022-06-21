package com.yedam.java.example2;

import java.util.Scanner;

public class StudentProgram implements Program {

	// 필드
	private Scanner sc = new Scanner(System.in);

	// 메서드
	@Override
	public void menuPrint() {
		System.out.println("==========================================");
		System.out.println("1.정보입력 | 2.전체조회 | 3.검색 | 4.분석 | 5.종료");
		System.out.println("==========================================");
	}

	@Override
	public void inputInfo(Access access) {
		// 사용자가 정보를 입력
		Student info = studentInfo();
		// 저장소에 등록
		access.insert(info);
	}

	private Student studentInfo() {
		System.out.print("학번 >>");
		int id = Integer.parseInt(sc.nextLine());
		System.out.print("이름 >> ");
		String name = sc.nextLine();
		System.out.print("점수 >> ");
		int score = Integer.parseInt(sc.nextLine());

		return new Student(id, name, score);
	}

	@Override
	public void printAllInfo(Access access) {
		Student[] list = access.selectAll();
		for (Student student : list) {
			student.showInfo();
		}
	}

	@Override
	public void printInfo(Access access) {
		try {
			
			// 검색 조건 입력
			int id = inputId();
			// 저장소에서 검색
			Student info = access.selectOne(id);
			// 출력
			info.showInfo();
			
		} catch (NullPointerException e) {
			System.out.println();
			System.out.println("없는 학번입니다.");
			System.out.println();
		}

	}

	private int inputId() {
		System.out.print("검색 학번 >>");
		return Integer.parseInt(sc.nextLine());
	}

	@Override
	public void printReport(Access access) {
		// 최고점수
		System.out.print("최고점수 > ");
		Student maxInfo = selectMaxScore(access);
		maxInfo.showInfo();
		// 최저점수
		System.out.print("최저점수 > ");
		Student minInfo = selectMinScore(access);
		minInfo.showInfo();
		// 평균
		System.out.print("평균 > ");
		double avgResult = calAvg(access);
		System.out.println(avgResult);
	}

	// 최고 점수
	private Student selectMaxScore(Access access) {
		Student[] list = access.selectAll();

		Student maxInfo = list[0];
		for (int i = 1; i < list.length; i++) {
			if (maxInfo.getStudentScore() < list[i].getStudentScore()) {
				maxInfo = list[i];
			}
		}
		return maxInfo;
	}

	// 최저 점수
	private Student selectMinScore(Access access) {
		Student[] list = access.selectAll();

		Student minInfo = list[0];
		for (int i = 1; i < list.length; i++) {
			if (minInfo.getStudentScore() > list[i].getStudentScore()) {
				minInfo = list[i];
			}
		}
		return minInfo;
	}

	// 평균
	private double calAvg(Access access) {
		Student[] list = access.selectAll();

		int sum = 0;
		for (Student student : list) {
			sum += student.getStudentScore();
		}

		return (double) sum / list.length;
	}

}
