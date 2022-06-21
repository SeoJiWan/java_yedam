package com.yedam.java.ch1003;

public class AccountExample {
	
	public static void main(String[] args) {
		
		Account account = new Account();
		
		account.deposit(10000);
		System.out.println("예금액 : " + account.getBalance());
		
		try {
			account.withDraw(300000);
		} catch (BalanceInsufficientException e) {
			System.out.println(e.getMessage());
		}
	}
}
