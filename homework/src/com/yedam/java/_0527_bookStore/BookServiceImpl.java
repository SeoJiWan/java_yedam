package com.yedam.java._0527_bookStore;

import java.util.Scanner;

public class BookServiceImpl implements BookService {

	// 필드
	private BookRepository bookRepository = BookRepositoryImpl.getBookRepositoryImpl();
	private Scanner sc = new Scanner(System.in);

	// 생성자
	public BookServiceImpl() {

		while (true) {
			try {

				menuPrint();

				int menuNo = menuSelect();

				if (menuNo == 1) {
					registerBookInfo();
				}

				else if (menuNo == 2) {
					checkOneBookInfo();
				}

				else if (menuNo == 3) {
					checkAllBookInfo();
				}

				else if (menuNo == 4) {
					analyzeBookInfo();
				}

				else if (menuNo == 5) {
					exit();
					break;
				}

				else {
					System.out.println();
					System.out.println("잘못된 입력입니다.");
					System.out.println();
				}

			} catch (NumberFormatException e) {
				System.out.println();
				System.out.println("잘못된 입력입니다.");
				System.out.println();
			}
		}
	}

	//// 메서드
	// 메뉴출력
	@Override
	public void menuPrint() {
		System.out.println();
		System.out.println("==========================================");
		System.out.println("1.등록 | 2.단일조회 | 3.전체조회 | 4.분석 | 5.종료");
		System.out.println("==========================================");
	}

	// 메뉴선택
	@Override
	public int menuSelect() {
		System.out.print("선택 >> ");
		int menuNo = Integer.parseInt(sc.nextLine());
		System.out.println();
		return menuNo;
	}

	// 도서정보등록
	@Override
	public void registerBookInfo() {
		bookRepository.insert(bookInfo());
	}

	// 도서정보
	private Book bookInfo() {
		System.out.print("책 이름 > ");
		String name = sc.nextLine();
		System.out.print("책 가격 > ");
		int price = Integer.parseInt(sc.nextLine());

		return new Book(name, price);
	}

	// 도서정보 단일조회
	@Override
	public void checkOneBookInfo() {
		try {
			System.out.print("ISBN > ");
			int ISBN = Integer.parseInt(sc.nextLine());

			bookRepository.selectOne(ISBN).showBookInfo();
			selectModifyOrDelete(ISBN);
			
		} catch (NullPointerException e) {
			System.out.println();
			System.out.println("잘못된 입력입니다.");
		}

	}

	// 조회서비스에 수정, 삭제 진행
	private void selectModifyOrDelete(int ISBN) {
		System.out.println();
		System.out.println("======================");
		System.out.println("1.수정 | 2.삭제 | 3.나가기");
		System.out.println("======================");
		System.out.print("선택 >> ");
		int menuNo = Integer.parseInt(sc.nextLine());
		System.out.println();

		if (menuNo == 1) {
			modifyBookInfo(ISBN);
			System.out.println("ISBN : " + ISBN + " 의 도서정보가 수정 되었습니다.");
		}

		else if (menuNo == 2) {
			deleteBookInfo(ISBN);
			System.out.println("ISBN : " + ISBN + " 의 도서정보가 삭제 되었습니다.");
		}

		else if (menuNo == 3) {

		}
	}

	// 도서정보수정
	@Override
	public void modifyBookInfo(int ISBN) {
		System.out.print("책 이름 > ");
		String name = sc.nextLine();

		System.out.print("책 가격 > ");
		int price = Integer.parseInt(sc.nextLine());
		System.out.println();

		bookRepository.update(ISBN, name, price);
	}

	// 도서정보삭제
	@Override
	public void deleteBookInfo(int ISBN) {
		bookRepository.delete(ISBN);
	}

	// 도서정보 전체조회
	@Override
	public void checkAllBookInfo() {
		Book[] bookList = bookRepository.selectAll();
		for (int i = 0; i < bookList.length; i++) {
			System.out.println((i + 1) + ".");
			bookList[i].showBookInfo();
		}
	}

	// 도서정보분석 - 가장 비싼 책 정보, 가장 싼 책 정보,, 위 두 가격을 제외한 책 정보, 가격 평균산출
	@Override
	public void analyzeBookInfo() {
		Book maxPriceBook = maxPriceBookInfo();
		System.out.print("최고가 책 정보 : ");
		maxPriceBook.showBookInfo();

		Book minPriceBook = minPriceBookInfo();
		System.out.print("최저가 책 정보 : ");
		minPriceBook.showBookInfo();
		System.out.println();

		int avgExceptMinMax = bookPriceAvgExceptMinMax();
		System.out.println("최고가, 최저가 제외한 평균가격 : " + avgExceptMinMax + "원");
	}

	// 가장 비싼 책 정보
	private Book maxPriceBookInfo() {
		Book[] bookList = bookRepository.selectAll();
		Book book = bookList[0];
		for (int i = 0; i < bookList.length; i++) {
			if (book.getBookPrice() < bookList[i].getBookPrice()) {
				book = bookList[i];
			}
		}
		return book;
	}

	// 가장 싼 책 정보
	private Book minPriceBookInfo() {
		Book[] bookList = bookRepository.selectAll();
		Book book = bookList[0];
		for (int i = 0; i < bookList.length; i++) {
			if (book.getBookPrice() > bookList[i].getBookPrice()) {
				book = bookList[i];
			}
		}
		return book;
	}

	// 평균
	private int bookPriceAvgExceptMinMax() {
		Book[] bookList = bookRepository.selectAll();

		Book maxPriceBook = maxPriceBookInfo();
		Book minPriceBook = minPriceBookInfo();

		// 내 코드 -> 최고가, 최저가 제외한 가격합 구하기
//		for (int i = 0; i < bookList.length; i++) {
//			if (bookList[i] == maxPriceBook || bookList[i] == minPriceBook) {
//				bookList[i] = null;
//			}
//		}
//
//		int sum = 0;
//		for (Book book : bookList) {
//			if (book != null) {
//				sum += book.getBookPrice();
//				book.showBookInfo();
//			}
//		}
		
		// 교수님 코드 -> 최고가, 최저가 제외한 가격합 구하기
		int sum = 0;
		for (Book book : bookList) {
			if (book.getBookPrice() > minPriceBook.getBookPrice() && book.getBookPrice() < maxPriceBook.getBookPrice()) {
				sum += book.getBookPrice();
				book.showBookInfo();
			}
		}

		int avg = sum / (bookList.length - 2);

		return avg;
	}

	@Override
	public void exit() {
		System.out.println("프로그램 종료");
	}

}
