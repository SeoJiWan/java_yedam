package com.yedam.java.example2;

public interface Program {
	// 메뉴출력
	void menuPrint();
	
	// 정보입력
	void inputInfo(Access access);
	
	// 입력된 전체정보를 출력
	void printAllInfo(Access access);
	
	// 특정 조건의 정보를 출력
	void printInfo(Access access);
	
	// 분석
	void printReport(Access access);
	

}
