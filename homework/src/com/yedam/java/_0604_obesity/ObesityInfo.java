package com.yedam.java._0604_obesity;

public class ObesityInfo extends StandardWeightInfo {

	/**
	 * @param name
	 * @param height
	 * @param weight
	 */
	public ObesityInfo(String name, double height, double weight) {
		super(name, height, weight);
	}

	
	// 메서드
	@Override
	public void getInfo() {
		System.out.println(toString() + ", " + getObesity(getWeight(), getStandardWeight(getHeight())) + "입니다.");
		
	}

	public String getObesity(double weight, double standardWeight) {
		double bmi = (weight - standardWeight) / (standardWeight * 100);
		if (bmi >= 30) {
			return "비만";
		} 
		else if (bmi < 30 && bmi >= 24) {
			return "과체중";
		} 
		else if (bmi < 24 && bmi >= 20) {
			return "정상";
		} 
		else if (bmi < 20 && bmi >= 15) {
			return "저체중";
		} 
		else if (bmi < 15 && bmi >= 13) {
			return "여윔";
		} 
		else if (bmi < 13 && bmi >= 10) {
			return "영양 실조증";
		} 
		else {
			return "소모증";
		}
	}

}
