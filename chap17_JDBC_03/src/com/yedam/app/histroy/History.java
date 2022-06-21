package com.yedam.app.histroy;

public class History {

	/*
	 * 필드
	 */
	private int productId;
	private int productCategory; // 1 : 입고, 2 : 출고
	private int productAmount;
	
	
	/*
	 * getter, setter
	 */
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(int productCategory) {
		this.productCategory = productCategory;
	}
	public int getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}
}
