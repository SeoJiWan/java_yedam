package com.yedam.java._0604_obesity;

public class StandardWeightInfo extends Human {

	
	/**
	 * @param name
	 * @param height
	 * @param weight
	 */
	public StandardWeightInfo(String name, double height, double weight) {
		super(name, height, weight);
	}

	
	// 메서드
	@Override
	public void getInfo() {
		System.out.println(toString() + ", 표준체중 " + getStandardWeight(getHeight()) + "입니다.");
	} 
	
	public double getStandardWeight(double height) {
		return (height - 100) * 0.9;
	}
	
	

}
