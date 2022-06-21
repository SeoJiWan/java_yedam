package com.yedam.java.ch1101;

import java.util.Date;

public class ToStringTest {
	
	public static void main(String[] args) {
		Object object = new Object();
		System.out.println(object.toString());
		
		Date date = new Date();
		System.out.println(date.toString());
		
		Member member = new Member("sfdgsd");
		System.out.println(member);
	}

}
