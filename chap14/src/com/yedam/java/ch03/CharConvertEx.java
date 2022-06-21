package com.yedam.java.ch03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class CharConvertEx {
	
	static String path = "D:/dev/temp/text1.txt";
	
	// 출력 스트림
	public static void write(String str) throws Exception {
		// 출력 스트림 생성 - 파라미터 : 경로
		OutputStream os = new FileOutputStream(path);
//		os.write(str); // --> outputstream 은 byte 기반이기 때문 String 을 바로 넘기지 못한다. --> 보조스트림을 이용하여 String으로 변환
		// 내보내는건 문자로 내보내고 싶음 --> 보조 스트림생성
		// 출력 스트림을 파라미터로 쓰기 객체인 Writer 생성
		Writer writer = new OutputStreamWriter(os);
		
		writer.write(str);
		writer.flush(); // buffer 밀어내기
		writer.close();
	}
	
	// 입력 스트림
	public static void read() throws IOException {
		InputStream is = new FileInputStream(path);
		Reader reader = new InputStreamReader(is);
		
		// 읽어들이는건 한 글자씩
		char[] buffer = new char[100];
		// 한 번만 읽을것임
		int readCharNum = reader.read(buffer); // buffer 배열에 "text1.txt" 파일 읽을 것을 한 글자씩 저장
		
		for (int i = 0; i < buffer.length; i++) {
			System.out.println("buffer [" + i + "]" + buffer[i]);
		}
		reader.close();
		
		String data = new String(buffer, 0, readCharNum); // buffer 배열에 담긴 문자를 길이만큼 String 으로 연결
		System.out.println("data : " + data);
	}
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("입력문장 >> ");
		String str = new Scanner(System.in).nextLine();
		write(str);
		read();
	}
}
