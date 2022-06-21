package com.yedam.java.ch02;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReaderEx {

	public static void main(String[] args) throws IOException {

		Reader reader = new FileReader("D:/dev/temp/test7.txt");

		while (true) {
			int data = reader.read();
			if (data == -1) {
				break;
			}
			System.out.println((char) data);
		}
		reader.close();

		System.out.println();
		
				
		reader = new FileReader("D:/dev/temp/test8.txt");
		
		char[] buf = new char[100];
		
		while (true) {
			int readCharNum = reader.read(buf); // 개수 리턴
			if (readCharNum == -1) {
				break;
			}
			for (int i = 0; i < readCharNum; i++) {
				System.out.println(buf[i]);
			}
			System.out.println();
		}
		reader.close();
		
		
		reader = new FileReader("D:/dev/temp/test10.txt");
		
		char[] buf2 = new char[100];
		int readCharNum = reader.read(buf2, 5, 10);
		System.out.println(readCharNum);
		for (int i = 0; i < 5+readCharNum; i++) {
			System.out.print(buf2[i]);
		}

		
	}

}
