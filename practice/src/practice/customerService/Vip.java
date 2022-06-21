package practice.customerService;

public class Vip extends Customer{

	// 필드
	protected double discountRatio;
	protected String employeeName;
	
	
	// 생성자
	protected Vip(String customerName, int customerPhoneNum, String employeeName) {
		super(customerName, customerPhoneNum);
		this.customerGrade = "VIP";
		this.accumRatio = 0.05;
		this.discountRatio = 0.2;
	}


	// 메서드
	protected double getDiscountRatio() {
		return discountRatio;
	}

	protected void setDiscountRatio(double discountRatio) {
		this.discountRatio = discountRatio;
	}

	protected String getEmployeeName() {
		return employeeName;
	}

	protected void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@Override
	protected int calcPrice_Accum(int price) {
		this.bonusPoint += price * this.accumRatio;
		return price - (int)(price * discountRatio);
	}
}
