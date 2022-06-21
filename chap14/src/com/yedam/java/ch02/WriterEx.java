package com.yedam.java.ch02;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterEx {

	public static void main(String[] args) throws IOException {

		// char 쓰기
		Writer writer = new FileWriter("D:/dev/temp/test7.txt");

		char a = 'A';
		char b = 'B';
		char c = 'C';

		writer.write(a);
		writer.write(b);
		writer.write(c);

		writer.flush();
		writer.close();

		
		// char 배열 쓰기
		writer = new FileWriter("D:/dev/temp/test8.txt");

		char[] arr = { 'A', 'B', 'C' };

		writer.write(arr);

		writer.flush();
		writer.close();

		
		// char 배열 인덱싱하여 쓰기
		writer = new FileWriter("D:/dev/temp/test9.txt");

		char[] arr2 = { 'A', 'B', 'C', 'D', 'E' };

		writer.write(arr2, 3, 2);

		writer.flush();
		writer.close();
		
		
		// String 쓰기
		writer = new FileWriter("D:/dev/temp/test10.txt");
		
		String str1 = "ABCDEFG";
		String str2 = "123456";
		
		writer.write(str1);
		writer.write(str2, 0, 4);
		
		writer.flush();
		writer.close();
		

	}

}
