package practice.customerService;

public class Gold extends Customer{

	// 필드
	protected double discountRatio;
	
	
	// 생성자
	protected Gold(String customerName, int customerPhoneNum) {
		super(customerName, customerPhoneNum);
		this.customerGrade = "GOLD";
		this.accumRatio = 0.02;
		this.discountRatio = 0.1;
	}

	
	// 메서드
	protected double getDiscountRatio() {
		return discountRatio;
	}

	protected void setDiscountRatio(double discountRatio) {
		this.discountRatio = discountRatio;
	}

	@Override
	protected int calcPrice_Accum(int price) {
		this.bonusPoint += price * this.accumRatio;
		return price - (int)(price * discountRatio);
	}
}
