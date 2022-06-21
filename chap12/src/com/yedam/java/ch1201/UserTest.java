package com.yedam.java.ch1201;

public class UserTest {
	
	public static void main(String[] args) {
		
		Calculator calculator = new Calculator(); 
//		calculator.setMemory(100);
		
		/*
		 * user1 과 user2 가 같은 Calculator 객체로 접근할 때
		 * sleep 이 일어나면서 user1 은 재우고 user2 가 접근
		 * -> memory 값이 같은 이유 
		 */
		
		User user1 = new User();
		user1.setCalc(calculator);
		user1.start();
		
		User user2 = new User();
		user2.setCalc(calculator);
		user2.start();
		
	}

}
