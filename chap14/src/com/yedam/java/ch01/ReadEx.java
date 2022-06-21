package com.yedam.java.ch01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadEx {

	public static void main(String[] args) throws IOException {

		InputStream is = new FileInputStream("D:/dev/temp/test1.db");

//		byte[] readAllBytes = is.readAllBytes();
//		for (byte b : readAllBytes) {
//			System.out.println(b);
//		}

		while (true) {
			int data = is.read();
			if (data == -1) {
				break;
			}
			System.out.println("data1 : " + data);
		}

		is.close();

		System.out.println();

		is = new FileInputStream("D:/dev/temp/test2.db");

		byte[] buf = new byte[5];
		while (true) {
			int readByteNum = is.read(buf);
			if (readByteNum == -1) {
				break;
			}

			for (int i = 0; i < readByteNum; i++) {
				System.out.println(buf[i]);
			}
			System.out.println();
		}

		is.close();

		System.out.println();

		is = new FileInputStream("D:/dev/temp/test3.db");

		int readByteNum = is.read(buf,3, 2);
		
		for (int i = 0; i < (3 + readByteNum); i++) {
			System.out.println(buf[i]);
		}
		
		is.close();
	}
}
