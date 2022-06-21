package com.yedam.java.ch1103;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	
	public static void main(String[] args) {
		
		Date now = new Date();
		System.out.println(now); // 외국식
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 k시 mm분 ss초"); // 형식 갖춰서
		String strNow = sdf.format(now); // Date 인스턴스 형식 변환
		System.out.println(strNow);
		
		
	}

}
