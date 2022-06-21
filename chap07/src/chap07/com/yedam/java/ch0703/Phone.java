package chap07.com.yedam.java.ch0703;

public abstract class Phone {
	
	public String model;
	public String color;
	
	
	public Phone(String model, String color) {
		super();
		this.model = model;
		this.color = color;
	}
	
	
	public void powerOn() {
		System.out.println("power on");
	}
	
	public void powerOff() {
		System.out.println("power off");
	}
	
	// 추상 메서드
	public abstract void bell();
	
	
	
	
}
