package chap07.com.yedam.java.ch0703;

public class PhoneTest {
	
	public static void main(String[] args) {
		
//		Phone phone = new Phone("아이폰se2", "black");
//		phone.powerOn();
		
		DmbPhone dmbPhone = new DmbPhone("아이폰se2", "black");
		dmbPhone.powerOn();
		dmbPhone.showDmb();
	}
}
