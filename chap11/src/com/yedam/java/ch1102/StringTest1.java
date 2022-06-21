package com.yedam.java.ch1102;

import java.io.UnsupportedEncodingException;

public class StringTest1 {

	public static void main(String[] args) {
		// byte -> String
		byte[] bytes = { 72, 101, 108, 108, 111, 32, 74, 97, 118, 97 };

		String str1 = new String(bytes);
		System.out.println(str1);

		String str2 = new String(bytes, 6, 4); // 인데스6 부터 4개 문자
		System.out.println(str2);

		// String -> byte -> String
		String str3 = "안녕하세요";

		byte[] bytes1 = str3.getBytes();
		System.out.println(bytes1);
		String strs3 = new String(bytes1);
		System.out.println(strs3);

		try {
			byte[] bytes2 = str3.getBytes("EUC-KR");
			System.out.println(bytes2);
			String strs2 = new String(bytes1);
			System.out.println(strs2);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// charAt
		String ssn = "010624-1230123";
		char gender = ssn.charAt(7);

		switch (gender) {
		case '1':
		case '3':
			System.out.println("male");
			break;
		case '2':
		case '4':
			System.out.println("female");
			break;
		}
		
		for (int i = 0; i < ssn.length(); i++) {
			System.out.println(ssn.charAt(i));
		}
		
		
		// equals
		String val1 = "wana";
		String val2 = "wana";
		String val3 = new String("wana"); // 새로운 인스턴스가 반듯 필요할 때 사용
		
		if (val1.equals(val2)) {
			System.out.println("val1 == val2");
		}
		if (val1.equals(val3)) {
			System.out.println("val1 == val3");
		}
		
		if (val1 == val2) {
			System.out.println("val1 == val2");
		}
		if (val1 == val3) {
			System.out.println("val1 == val3");
		}
		
		
		// indexOf
		String subject = "자바 프로그래밍";
		int loc = subject.indexOf("프로그래밍");
		System.out.println(loc);
		
		if (subject.indexOf("자바") != -1) { // "자바" 가 포함되어있는지 확인.
			System.out.println("자바와 관련된 책");
		} else {
			System.out.println("자바와 관련없는 책");
		}
		
		
		// substring
		String result1 = subject.substring(subject.indexOf("프로그래밍"));
		System.out.println(result1);
		
		String ssn1 = "880815-1234567";
		System.out.println(ssn1.substring(0, 6));
		System.out.println(ssn1.substring(7));
				
		
		// length
		String[] tmp = { "1", "2" };
		int val = tmp.length;
		System.out.println(val);
		
		
		// replace
		String oldStr = "java programming java";
		String newStr = oldStr.replace("java", "python");
		System.out.println(newStr);
	}

}
