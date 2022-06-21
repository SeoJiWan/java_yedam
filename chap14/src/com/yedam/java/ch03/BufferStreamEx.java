package com.yedam.java.ch03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;

public class BufferStreamEx {
	
	static int data = -1;
	
	public static long copy(InputStream is, OutputStream os) throws Exception {
		// 시작 시간
		long start = System.nanoTime();
		
		while (true) {
			data = is.read();
			if (data == -1) {
				break;
			}
			os.write(data);
		}
		
		// 끝나는 시간
		long end = System.nanoTime();
		
		return (end - start);
	}
	
	
	public static void main(String[] args) throws Exception {
		
		// buffer 스트림 없는 경우
		String originFilePath1 = BufferStreamEx.class.getResource("originalFile1.jpg").getPath(); // jpg file path
//		System.out.println(originFilePath1);
		String targetFilePath1 = "D:/dev/temp/targetFile1.jpg";
		
		InputStream fis1 = new FileInputStream(originFilePath1); // 입력
		OutputStream fos1 = new FileOutputStream(targetFilePath1); // 출력
		
		long nonBufferTime = copy(fis1, fos1);
		System.out.println("nonBufferTime : " + nonBufferTime + "ns");
		
		
		// buffer 스트림 있는 경우
		String originFilePath2 = BufferStreamEx.class.getResource("originalFile2.jpg").getPath(); // jpg file path
//		System.out.println(originFilePath2);
		String targetFilePath2 = "D:/dev/temp/targetFile2.jpg";
		
		InputStream fis2 = new FileInputStream(originFilePath2); // 입력
		OutputStream fos2 = new FileOutputStream(targetFilePath2); // 출력
		
		BufferedInputStream bis = new BufferedInputStream(fis2); // 버퍼 스트림 사용 - 매개변수 : 입력스트림 
		BufferedOutputStream bos = new BufferedOutputStream(fos2);
		
		long useBufferTime = copy(bis, bos);
		System.out.println("useBufferTime : " + useBufferTime + "ns");
		
		
		// 시간 결과 비교
		System.out.println(nonBufferTime/useBufferTime + "배 차이"); 
	}

}
