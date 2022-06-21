package chap01;

public class Hello {
	
	public static void greetEn() {
		System.out.println("Hello");
	}
	
	public static void greet() {
		System.out.println("안녕");
	}
	
	public static void info() {
		System.out.println("서지완");
	}
	

	public static void main(String[] args) {
		// 영어로 인사
//		System.out.println("Hello World !");
		greetEn();
		
		// 한글로 인사
//		System.out.println("안녕");
		greet();
		
		// 자기 이름
//		System.out.println("서지완");
		info();
	}
}
