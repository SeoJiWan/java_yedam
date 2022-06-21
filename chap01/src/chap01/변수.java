package chap01;

/* 
 * 변수의 타입 (유형) :
 * 				변수 -> 메모리의 저장위치, 값을 저장하는 공간
 * 				유형 -> 메모리에 값을 저장하는 형식 (구조와 크기가 다름)
 * 			
 *           1      2       4     8  
 * 숫자	정수	 byte	short	int	  long
 * 
 * 			 7		15
 *		실수	 float	double 	유효자릿수 정밀도
 * 
 * 문자	한글자  char   --> 'a', '가'
 * 		여러글자 String --> "홍길동"
 * 
 * 논리 	true or false
 * 
 * 날짜
 */

public class 변수 { 

	public static void main(String[] args) {
		
		// 숫자형
		long rich = 2200000000l; // 상수값 long 사용하려면 접미어 L or l 사용
		float avg = 0.123456789f; // float형 변수 avg를 선언하고 상숙밧 84.5를 변수에 저장
		double totalAge = 0.12345678903246542489456;
		
		int korScore =128; // 상수값의 기본형은 int
		int engScore = 10; // 변수선언, 초기화 동시에 진행
		int mathScore; // 변수선언
		mathScore = 100; // 초기화
		int int2 = 0b1111111;
		int int8 = 017;
		int int16 = 0x7F;
		
		System.out.println("int2 : \\" + int2 + "\\");
		System.out.println("int8 : \"" + int8 + "\"");
		System.out.println("int16 : " + int16);
		
		System.out.println(avg);
		System.out.println(totalAge);
		System.out.println(engScore);
		
		
		// 문자형
		char grade = '가';
		String grade2 = "A+";
		
		System.out.println("grade = " + (int) grade);
		
		char code = 44033;
		System.out.println("44033 문자 = " + code);
		
		
		// 논리형
		boolean passYn = true;
		int k = 50, e= 50, m = 50;
		boolean result = k > 50 && e > 50 && m > 50;
		System.out.println("result : " + result);
	}
	

}
