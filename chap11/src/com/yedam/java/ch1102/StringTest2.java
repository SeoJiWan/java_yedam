package com.yedam.java.ch1102;

public class StringTest2 {
	
	public static void main(String[] args) {
		
		// toLowerCase & toUpperCase
		String str1 = "Java Programming";
		String str2 = "JAVA PROGRAMMING";
		System.out.println(str1.toLowerCase());
		System.out.println(str1.toUpperCase());
		
		System.out.println(str1);
		
		System.out.println(str1.equals(str2));
		System.out.println(str1.equalsIgnoreCase(str2));
		
		
		// trim
		String subject = "          java       programming      ";
		String trimSubject = subject.trim();
		System.out.println(trimSubject);
		String str = trimSubject.replace("       ", " ");
		System.out.println(str);
		
		String blank = " ";
		int blankIdx = trimSubject.indexOf(blank);
		String strA = trimSubject.substring(0, blankIdx);
		String strB = trimSubject.substring(blankIdx);
		strB = strB.trim();
		String newStr = strA + " " + strB;
		System.out.println(newStr);
		
		
		// valueOf --> String 이 아닌 타입을 String 으로 변환
		String val1 = String.valueOf(10);
		String val2 = String.valueOf(10.5);
		String val3 = String.valueOf(true);
		System.out.println(val1);
		System.out.println(val2);
		System.out.println(val3);
		String val4 = "" + 100; // 현업에서 많이 사용
	}

}
