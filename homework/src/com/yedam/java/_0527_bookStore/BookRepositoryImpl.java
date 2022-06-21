package com.yedam.java._0527_bookStore;

public class BookRepositoryImpl implements BookRepository {

	// 필드
	private static BookRepositoryImpl bookRepositoryImpl = new BookRepositoryImpl(); // 싱글톤
	private Book[] dataList;
	private int listIdx;
	
	
	// 생성자
	private BookRepositoryImpl() {
		init();
	}

	
	//// 메서드
	// 싱글톤으로 인스턴스 생성
	public static BookRepositoryImpl getBookRepositoryImpl() {
		return bookRepositoryImpl;
	}
	
	// init
	private void init() {
		dataList = new Book[100];
		listIdx = -1;
	}
	
	// 삽입
	@Override
	public void insert(Book book) {
		dataList[++listIdx] = book;
	}
	
	// 단일조회
	@Override
	public Book selectOne(int ISBN) {
		Book book = null;
		for (int i = 0; i <= listIdx; i++) {
			if (dataList[i].getISBN() == ISBN) {
				book = dataList[i];
				break;
			}
		}
		return book;
		
	}

	// 전체조회
	@Override
	public Book[] selectAll() {
		Book[] tmpList = new Book[listIdx + 1];
		for (int i = 0; i <= listIdx; i++) {
			tmpList[i] = dataList[i];
		}
		return tmpList;
	}

	// 삭제
	@Override
	public void delete(int ISBN) {
		int delIdx = 0;
		for (int i = 0; i <= listIdx; i++) {
			if (dataList[i].getISBN() == ISBN) {
				dataList[i] = null;
				delIdx = i;
			}
		}
//		cleanDataList();
		
		// 삭제 후 데이터 정리
		for (int i = delIdx; i <= listIdx - 1; i++) {
			dataList[i] = dataList[i + 1];
		}
		dataList[listIdx--] = null;
	}
	
//	// 삭제 후 데이터정리
//	private void cleanDataList() {
//		// datalist, idx 복사
//		Book[] tmpList = dataList;
//		int tmpListIdx = listIdx;
//		
//		// datalist, idx 초기화
//		init();
//		
//		// tmp 의 값이 null 이 아니면 datalist 에 추가
//		for (int i = 0; i <= tmpListIdx; i++) {
//			if (tmpList[i] != null) {
//				dataList[++listIdx] = tmpList[i];
//			}
//		}
//	}

	// 수정
	@Override
	public void update(int ISBN, String bookName, int bookPrice) {
		selectOne(ISBN).setBookName(bookName);
		selectOne(ISBN).setBookPrice(bookPrice);
	}
}
