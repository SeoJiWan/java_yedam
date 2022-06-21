package chap07.com.yedam.java.ch0702.Car;

public class HankookTire extends Tire{

	public HankookTire(int maxRotation, String location) {
		super(maxRotation, location);
	}
	
	
	@Override
	public boolean roll() {
		++accumulationRotation;
		if (accumulationRotation < maxRotation) {
			System.out.println(location + " Hankook Tire 수명 : " + (maxRotation - accumulationRotation));
			return true;
		}
		else {
			System.out.println("*** " + location + " Hankook Tire 펑크 ***");
			return false;
		}
	}

}
