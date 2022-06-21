package chap07.com.yedam.java.ch0702.Car;

public class Car {

	Tire frontLeftTire = new Tire(6, "앞 왼쪽");
	Tire frontRightTire = new Tire(3, "앞 오른쪽");
	Tire backLeftTire = new Tire(6, "뒤 왼쪽");
	Tire backRightTire = new Tire(6, "뒤 오른쪽");

	int run() {
		System.out.println("[Car is running]");
		if (frontLeftTire.roll() == false) {
			stop();
			return 1;
		}

		if (frontRightTire.roll() == false) {
			stop();
			return 2;
		}
		
		if (backLeftTire.roll() == false) {
			stop();
			return 3;
		}
		
		if (backRightTire.roll() == false) {
			stop();
			return 4;
		}
		
		return 0;
	}
	
	void stop() {
		System.out.println("[Car is stop]");
	}

}
