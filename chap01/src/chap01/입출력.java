package chap01;

import java.io.IOException;

public class 입출력 {
	
	public static void main(String[] args) throws IOException {
		
		// 출력
		int kor = 100;
		int eng = 57;
		double avg = (double) (kor + eng) / 2;
		
		String korName = "국어";
		String engName = "영어";
		
		System.out.println("국어는 : " + kor + ", 영어는 : " + eng);
		System.out.printf("%s는 : %d, \n%s는 : %d, \n평균은 : %4.1f", korName, kor, engName, eng, avg);
		System.out.println();
		
		
		// 입력
		int keyCode = System.in.read();
		System.out.println("keyCode : " + keyCode);
	}

}
