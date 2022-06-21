package chap07.com.yedam.java.example1;

public class Customer {
	
	// 필드
	protected int customerId;
	protected String name;
	protected String rank;
	protected int bonusPoint;
	protected double bonusPointRatio;
	
	
	// 생성자
	protected Customer(int customerId, String name) {
		this.customerId = customerId;
		this.name = name;
		this.rank = "Silver";
		this.bonusPointRatio = 0.01;
	}
	
	
	// 메서드
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public int getBonusPoint() {
		return bonusPoint;
	}

	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}

	public double getBonusPointRatio() {
		return bonusPointRatio;
	}

	public void setBonusPointRatio(double bonusPointRatio) {
		this.bonusPointRatio = bonusPointRatio;
	}

	protected int calcPrice(int price) {
		this.bonusPoint += price * this.bonusPointRatio;
		return price;
	}
	
	protected String showInfo() {
		return "고객 이름 : " + this.name + ", 등급 : " + this.rank + ", 포인트 : " + this.bonusPoint;
	}

}
