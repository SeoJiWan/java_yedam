package com.yedam.app.product;

/*
 * VO
 */
public class Product {
	
	/*
	 * 필드
	 */
	private int productId;
	private String prodctName;
	private int productPrice;
	
	
	/*
	 * getter, setter
	 */
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProdctName() {
		return prodctName;
	}
	public void setProdctName(String prodctName) {
		this.prodctName = prodctName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	@Override
	public String toString() {
		return "제품번호 : " + productId +
				", 제품이름 : " + prodctName +
				", 제품가격 : " + productPrice;
	}
}
