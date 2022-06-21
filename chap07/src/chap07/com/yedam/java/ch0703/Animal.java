package chap07.com.yedam.java.ch0703;

public abstract class Animal { // 추상메서드가 있으면 클래스는 추상클래스가 되어야 한다.
	
	public void breath() {
		System.out.println("숨을 쉬어라");
	}
	
	public abstract void sound();

}
