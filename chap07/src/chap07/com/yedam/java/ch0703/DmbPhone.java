package chap07.com.yedam.java.ch0703;

public class DmbPhone extends Phone{

	
	public DmbPhone(String model, String color) {
		super(model, color);
	}

	@Override
	public void powerOn() {
		System.out.println("부팅 완료");
	}
	
	public void showDmb() {
		System.out.println("dmb 를 봅니다.");
	}

	@Override
	public void bell() {
		System.out.println("따르릉");
	}
	
	

	
}
