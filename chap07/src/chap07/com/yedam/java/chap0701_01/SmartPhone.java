package chap07.com.yedam.java.chap0701_01;

import chap07.com.yedam.java.chap0701.Phone;

public class SmartPhone extends Phone{

	public SmartPhone(String model, String color) {
		super(model, color);
	}

	
	
	@Override
	public void bell() {
		// TODO Auto-generated method stub
		super.bell();
		System.out.println("벨 소리 : PSY - that that!");
	}

	@Override
	protected void call() {
		// TODO Auto-generated method stub
		super.call();
		System.out.println("전화는 용건만 간단히");
	}
	
	private void print() {
		System.out.println();
	}
	
	

}
