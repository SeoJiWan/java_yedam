package chap07.com.yedam.java.ch0702.Car;

public class CarTest {

	public static void main(String[] args) {

		Car car = new Car();

		for (int i = 0; i < 10; i++) {
			int problemLocation = car.run();

			switch (problemLocation) {
			case 1:
				System.out.println("앞 왼쪽 타이어 교체");
				car.frontLeftTire = new HankookTire(14, "앞 왼쪽");
				break;
			case 2:
				System.out.println("앞 오른쪽 타이어 교체");
				car.frontRightTire = new HankookTire(12, "앞 오른쪽");
				break;
			case 3:
				System.out.println("뒤 왼쪽 타이어 교체");
				car.backLeftTire = new KumhoTire(10, "뒤 왼쪽");
				break;
			case 4:
				System.out.println("뒤 오른쪽 타이어 교체");
				car.backRightTire = new KumhoTire(13, "뒤 오른쪽");
				break;
			default:
				break;
			}
		}
	}

}
