package practice.customerService;

public class Customer {
	
	// 필드
	protected static int serialNo = 1002;
	protected String customerName;
	protected int customerPhoneNum;
	protected String customerGrade;
	protected int bonusPoint;
	protected double accumRatio;
	
	
	// 생성자
	protected Customer(String customerName, int customerPhoneNum) {
		this.customerName = customerName;
		this.customerPhoneNum = customerPhoneNum;
		this.customerGrade = "SILVER";
		this.bonusPoint = 0;
		this.accumRatio = 0.01;
	}


	// 메서드
	protected String getCustomerName() {
		return customerName;
	}

	protected void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	protected int getCustomerPhoneNum() {
		return customerPhoneNum;
	}

	protected void setCustomerPhoneNum(int customerPhoneNum) {
		this.customerPhoneNum = customerPhoneNum;
	}
	
	protected int calcPrice_Accum(int price) {
		this.bonusPoint += price * this.accumRatio;
		return price;
	}

	protected String customerInfo() {
		return toString();
	}
	
	@Override
	public String toString() {
		return "Customer [ customerName = " + customerName + ", customerGrade = " + customerGrade + ", bonusPoint = "
				+ bonusPoint + " ]";
	}
	
	
	

	

}
