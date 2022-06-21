package com.yedam.java._0604_obesity;

public class Human {
	
	// 필드
	private String name;
	private double height;
	private double weight;
	
	
	/**
	 * @param name
	 * @param height
	 * @param weight
	 */
	public Human(String name, double height, double weight) {
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	
	
	// 메서드
	public void getInfo() {
		System.out.println(toString());
	}
	

	@Override
	public String toString() {
		return this.name + "님의 신장 " + this.height + ", 몸무게 " + weight;
	}

	public String getName() {
		return name;
	}

	public double getHeight() {
		return height;
	}


	public double getWeight() {
		return weight;
	}
}
