package chap07.com.yedam.java.chap0701;

public class DmbPhone extends Phone{
	int ch;
	
	DmbPhone(String model, String color) {
		super(model, color); // 부모 클래스 (Phone) 생성자 생성하면 super 에 파라미터 지정
//		super.model = model;
//		super.color = color;
		this.ch = 10;
	}
	
	void turnOnDmb() {
		System.out.println("채널 " + ch + " 번 방송 수신을 합니다.");
	}
	
	void turnOffDmb() {
		System.out.println("방송 수신을 멈춥니다.");
	}
	
	void changeChannel(int ch) {
		this.ch = ch;
		System.out.println("채널 " + ch + " 번으로 바꿉니다.");
	}

	@Override
	protected void bell() {
		// TODO Auto-generated method stub
		super.bell();
		System.out.println("진동이 울립니다.");
	}

	@Override
	protected void call() {
		// TODO Auto-generated method stub
		super.call();
	}
	
	
	
	
	

}
