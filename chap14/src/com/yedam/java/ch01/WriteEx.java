package com.yedam.java.ch01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteEx {

	public static void main(String[] args) throws IOException {

		OutputStream os = new FileOutputStream("D:/dev/temp/test1.db");

		byte a = 10;
		byte b = 20;
		byte c = 30;

		os.write(a);
		os.write(b);
		os.write(c);

		// 밀어내기 - 입력속도와 읽는속도가 다르기 때문에 한번 밀어내줘야함 --> 없으면 데이터 손실가능성 있음
		os.flush();
		os.close();

		// 배열 쓰기
		os = new FileOutputStream("D:/dev/temp/test2.db");

		byte[] arr1 = { 40, 50, 60 };

		os.write(arr1);

		os.flush();
		os.close();

		
		os = new FileOutputStream("D:/dev/temp/test3.db");

		byte[] arr2 = { 10, 20, 30, 40, 50 };

		// 배열 인덱싱하여 쓰기, 인덱스 3부터 2개
		os.write(arr2, 3, 2);

		os.flush();
		os.close();
	}

}
