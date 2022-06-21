package chap07.com.yedam.java.chap0701;

public class MainTest {
	
	public static void main(String[] args) {
		DmbPhone dmbPhone = new DmbPhone("슬라이드폰", "black");
		
		System.out.println("모델 : " + dmbPhone.model);
		System.out.println("색상 : " + dmbPhone.color);
		System.out.println("채널 : " + dmbPhone.ch);
		
		dmbPhone.powerOn();
		dmbPhone.bell();
		dmbPhone.call();
		dmbPhone.turnOnDmb();
	}

}
