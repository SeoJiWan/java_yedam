package com.yedam.java._0527_bookStore;

public class Book {
	
	// 필드
	private static int serialNo = 1001;
	private int ISBN;
	private String bookName;
	private int bookPrice;
	
	
	// 생성자
	public Book(String bookName, int bookPrice) {
		this.ISBN = serialNo;
		serialNo++;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
	}


	// 메서드
	public static int getSerialNo() {
		return serialNo;
	}

	public static void setSerialNo(int serialNo) {
		Book.serialNo = serialNo;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	public void showBookInfo() {
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "Book [ ISBN = " + ISBN + ", bookName = " + bookName + ", bookPrice = " + bookPrice + "원 ]";
	}
}
