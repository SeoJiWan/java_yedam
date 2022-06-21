package chap07.com.yedam.java.example1;

public class Gold extends Customer{

	// 필드
	protected double discoutRatio;
	
	
	// 생성자
	protected Gold(int customerId, String name) {
		super(customerId, name);
		this.rank = "Gold";
		this.bonusPointRatio = 0.02;
		this.discoutRatio = 0.1;
	}
	

	// 메서드
	public double getDiscoutRatio() {
		return discoutRatio;
	}

	public void setDiscoutRatio(double discoutRatio) {
		this.discoutRatio = discoutRatio;
	}

	@Override
	protected int calcPrice(int price) {
		super.calcPrice(price);
		return price - (int)(price * discoutRatio);
	}
	
	
}
