package com.yedam.java.homework;
	
/*
 * 1. 상품 수 입력
 * 2. 상품 및 가격 입력
 * 3. 베품별 가격 출력
 * 4. 분석
 * 5. 종료
 */

public class ProductSystem {
	private Product[] list;
	private int idx;
	
	public ProductSystem() {
		idx = -1;
	}
	
	// 메서드
	// 1. 상품수 입력
	public void setProductNum(int size) {
		list = new Product[size];
	}
	
	// 2. 상품 및 가격입력
	public void setProductInfo(String name, int price) {
		
		if (idx + 1 < list.length) {
			Product product = new Product();
			product.setProductName(name);
			product.setProductPrice(price);
			
			list[++idx] = product;
		}
		
		else {
			System.out.println("상품 수를 초과하였습니다.");
		}
	}
	
	// 3. 제품별 가격출력
	public void showProductInfo() {
		for (int i = 0; i < idx + 1; i++) {
			list[i].showInfo();
		}
	}
	
	
	// 4. 분석 - 최고가 제품, 최고가 제품 제외한 제품들의 가격 총합
	public void analysis() {
		
		int maxPrice = list[0].getProductPrice();
		String maxPriceProduct = list[0].getProductName();
		int sum = 0;
		
		for (int i = 1; i < idx + 1; i++) {
			if (maxPrice < list[i].getProductPrice()) {
				maxPrice = list[i].getProductPrice();
				maxPriceProduct = list[i].getProductName();
			}
		}
		
		for (int i = 0; i < idx + 1; i++) {
			sum += list[i].getProductPrice();
		}
		
		sum -= maxPrice;
		
		System.out.println("최고가 상품 : " + maxPriceProduct);
		System.out.println("총 가격 (최고가 제외) : " + sum);
	}
	
	// 4. 분석 - 교수님 코드
	public Product getMaxProductInfo() {
		Product maxInfo = list[0];
		
		for (int i = 1; i < list.length; i++) {
			if (maxInfo.getProductPrice() < list[i].getProductPrice())
			maxInfo = list[i];
		}
		
		return maxInfo; // main 에서 쓸 때는 maxInfo.getProductName(), maxInfo.getProductPrice() 
	}
	
	public int getTotalPrice() {
		int sum = 0;
		for (Product product : list) {
			sum += product.getProductPrice();
		}
		
		int resultSum = sum - getMaxProductInfo().getProductPrice();
		
		return resultSum;
	}
	
	
}
