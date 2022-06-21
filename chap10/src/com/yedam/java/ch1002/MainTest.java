package com.yedam.java.ch1002;

public class MainTest {
	
	public static void main(String[] args) {
		try {
			// 실행코드
		} catch (Exception e) {
			// 예외 발생시 처리코드
		} finally {
			// 정상실행, 예외발생 시 반드시 실행되는 코드
		}
		
		String data1 = null;
		String data2 = null;
		
		try {
			int value1 = Integer.parseInt(data2);
			
			data1 = args[0];
			data2 = args[1];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("실행 매개값의 수가 부족합니다.");
			return;
		} catch (NumberFormatException e) {
			System.out.println("숫자형식에 맞춰 입력해주세요");
		} finally {
			System.out.println("필수 구문");
		}
		System.out.println("메인 메서드 종료");
		
		try {
			findClass();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void findClass() throws ClassNotFoundException {
		Class class1 = Class.forName("java.lang.String");
		System.out.println(class1);
	}
}
