package com.yedam.java._0527_bookStore;

/*
 * - BookShop Service
 * 0.메뉴출력
 * 0.메뉴선택
 * 1.도서정보 등록
 * 2.도서정보 단일조회
 * 3.도서정보 전체조회
 * 4.도서정보 삭제 - 2.에서 진행
 * 5.도서정보 수정 - 2.에서 진행
 * 6.도서정보 분석
 * 7.시스템 종료
 */
public interface BookService {
	
	void menuPrint();
	
	int menuSelect();
	
	void registerBookInfo();
	
	void checkOneBookInfo();
	
	void checkAllBookInfo();
	
	void deleteBookInfo(int ISBN);
	
	void modifyBookInfo(int ISBN);
	
	void analyzeBookInfo();
	
	void exit();

}
