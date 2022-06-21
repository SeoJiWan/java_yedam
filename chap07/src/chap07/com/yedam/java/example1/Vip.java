package chap07.com.yedam.java.example1;

public class Vip extends Customer{

	// 필드
	protected double discoutRatio;
	protected String employee;
	
	
	// 생성자
	protected Vip(int customerId, String name, String employeeName) {
		super(customerId, name);
		this.rank = "VIP";
		this.bonusPointRatio = 0.05;
		this.discoutRatio = 0.15;
		this.employee = employeeName;
	}
	

	// 메서드
	public double getDiscoutRatio() {
		return discoutRatio;
	}

	public void setDiscoutRatio(double discoutRatio) {
		this.discoutRatio = discoutRatio;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	@Override
	protected int calcPrice(int price) {
		super.calcPrice(price);
		return price - (int)(price * discoutRatio);
	}
	
	@Override
	protected String showInfo() {
		return super.showInfo() + ", 담당직원 : " + this.employee;
	}
	
	

}
