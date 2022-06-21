package chap07.com.yedam.java.ch0702.Car;

public class Tire {
	public int maxRotation; // 타이어 수명
	public int accumulationRotation; // 누적 회전수
	public String location; // 타이어 조립 위치
	
	
	public Tire(int maxRotation, String location) {
		this.maxRotation = maxRotation;
		this.location = location;
	}
	
	
	public boolean roll() {
		++accumulationRotation;
		if (accumulationRotation < maxRotation) {
			System.out.println(location + " Tire 수명 : " + (maxRotation - accumulationRotation));
			return true;
		}
		else {
			System.out.println("*** " + location + " Tire 펑크 ***");
			return false;
		}
		
	}
	
	
	
	
	
	

}
