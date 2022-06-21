package com.yedam.java.homework;

public class Product {
	// 필드
	private String productName;
	private int productPrice;

	// 생성자
	
	// 메서드

	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public int getProductPrice() {
		return productPrice;
	}
	
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	
	public void showInfo() {
		System.out.println(this.productName + " : " + this.productPrice);
	}
}
