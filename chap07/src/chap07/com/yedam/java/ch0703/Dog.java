package chap07.com.yedam.java.ch0703;

public class Dog extends Animal{ // 추상클래스 상속시 --> 1. 자식클래스를 추상 클래스로,
//											         2. 추상메서드를 오버라이딩

	@Override
	public void sound() {
		System.out.println("멍멍");
	}

}
