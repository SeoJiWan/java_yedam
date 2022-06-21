package chap07.com.yedam.java.chap0701;

public class Phone {
	String model;
	String color;
	boolean power;
	
	
	public Phone(String model, String color) {
		this.model = model;
		this.color = color;
	}
	
	
	final void powerOn() {
		this.power = true;
		System.out.println("전원을 켭니다.");
	}
	
	final void powerOff() {
		this.power = false;
		System.out.println("전원을 끕니다.");
	}

	protected void bell() {
		if (this.power == true) {
			System.out.println("벨이 울립니다.");
		}
		else {
			System.out.println("전원을 켜십시오.");
		}
	}
	
	protected void call() {
		if (this.power == true) {
			System.out.println("통화를 합니다.");
		}
		else {
			System.out.println("전원을 켜십시오.");
		}
	}
	
}
