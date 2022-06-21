package com.yedam.java._0527_bookStore;

/*
 * - Book DB
 * 1.삽입
 * 2.조회 - 단일 조회, 전체 조회
 * 3.삭제
 * 4.수정
 */
public interface BookRepository {

	void insert(Book book);
	
	Book selectOne(int ISBN);
	
	Book[] selectAll();
	
	void delete(int ISBN);

	void update(int ISBN, String bookName, int bookPrice);
}
