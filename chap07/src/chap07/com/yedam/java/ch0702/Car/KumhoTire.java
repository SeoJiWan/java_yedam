package chap07.com.yedam.java.ch0702.Car;

public class KumhoTire extends Tire{

	public KumhoTire(int maxRotation, String location) {
		super(maxRotation, location);
	}

	
	@Override
	public boolean roll() {
		++accumulationRotation;
		if (accumulationRotation < maxRotation) {
			System.out.println(location + " Kumho Tire 수명 : " + (maxRotation - accumulationRotation));
			return true;
		}
		else {
			System.out.println("*** " + location + " Kumho Tire 펑크 ***");
			return false;
		}
	}
}
