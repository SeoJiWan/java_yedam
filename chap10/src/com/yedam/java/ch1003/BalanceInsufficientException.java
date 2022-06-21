package com.yedam.java.ch1003;

/*
 * 예외 클래스 만들기
 */
public class BalanceInsufficientException extends Exception {
	
	public BalanceInsufficientException() {

	}

	public BalanceInsufficientException(String message) {
		super(message);
	}

}
