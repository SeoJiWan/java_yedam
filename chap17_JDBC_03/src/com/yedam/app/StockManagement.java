package com.yedam.app;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.sound.sampled.Port;

import com.yedam.app.common.Info;
import com.yedam.app.histroy.History;
import com.yedam.app.histroy.HistroyDAO;
import com.yedam.app.product.Product;
import com.yedam.app.product.ProductDAO;

public class StockManagement {

	/*
	 * 필드
	 */
	private Scanner sc = new Scanner(System.in);
	private ProductDAO pDao = ProductDAO.getProductDAO();
	private HistroyDAO hDao = HistroyDAO.getHistroyDAO();
	
	
	/*
	 * 생성자
	 */
	public StockManagement() {
		while(true) {
			// 메뉴출력
			menuPrint();
			
			// 메뉴입력
			int menuNo = selectMenu();
			
			// 각 기능별 실행
			if (menuNo == 1) {
				// 제품 등록
				insertProduct();
			}
			else if (menuNo == 2) {
				// 제품입고
				productIn();
			}
			else if (menuNo == 3) {
				// 제품출고
				productOut();
			}
			else if (menuNo == 4) {
				// 제품재고
				productStock();
			}
			else if (menuNo == 5) {
				// 전체체품재고
				allProductStock();
			}
			else if (menuNo == 9) {
				// 종료
				exit();
				break;
			}
			else {
				showIinputError();
			}

		}
	}
	
	
	/*
	 * 메서드
	 */
	//// 주요 메서드
	// 메뉴출력
	private void menuPrint() {
		System.out.println("=======================================================");
		System.out.println("1.제품등록 | 2.입고 | 3.출고 | 4.재고검색 | 5.전체재고검색 | 9.종료");
		System.out.println("=======================================================");
	}
	
	// 메뉴선택
	private int selectMenu() {
		int menu = 0;
		
		try {
			System.out.print("선택 >> ");
			menu = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("숫자형식으로 입려하세요.");
		}
		return menu;
	}
	
	// 종료
	private void exit() {
		System.out.println("프로그램을 종료합니다.");
		pDao.disconnect();
	}
	
	// 입력 에러
	private void showIinputError() {
		System.out.println("메뉴를 참고하여 입력하세요.");
	}
	
	// 제품등록
	private void insertProduct() {
		// 제품 정보 입력
		Product product = inputProductInfo();
				
		// DB 저장
		pDao.insert(product);
	}
	
	// 제품 입고
	private void productIn() {
		// 입고할 제품과 수량 입력
		Info info = inputAmountInfo();
		
		// 기존에 등록된 제품인지 확인
		Product product = pDao.selectOne(info.getProductName());
		
		if (product != null) {
			// -1 기존에 등록된 제품일 경우 입고처리
			History history = new History();
			history.setProductId(product.getProductId());
			history.setProductCategory(1);
			history.setProductAmount(info.getProductAmount());
			
			hDao.insert(history);
		}
		else {
			// -2 기존에 등록되지 않은 경우 별도 안내
			System.out.println("해당 제품을 우선 등록해주세요.");
		}
	}
	
	// 제품 출고
	private void productOut() {
		// 출고할 제품과 수량을 입력
		Info info = inputAmountInfo();
		
		// 등록된 제품인지 확인
		Product product = pDao.selectOne(info.getProductName());
		
		//// 교수님 코드
		if (product == null) {
			System.out.println("해당 제품의 정보를 확인해주세요.");
			return;
		}
		// 재고량 있는지 확인
		int stock = selectStock(product.getProductId());
		// 재고량과 출고량을 비교
		if (stock >= info.getProductAmount()) {
			// -1 조건을 모두 만족하는 경우 출고처리
			History history = new History();
			history.setProductId(product.getProductId());
			history.setProductCategory(2);
			history.setProductAmount(info.getProductAmount());
			
			hDao.insert(history);
		}
		else {
			System.out.println("출고량이 재고량을 초과합니다.");
		}
		
		// 내 코드
//		Map<Integer, Integer> stockInfo = hDao.selectAllAmount();
//		if (product != null) {
//			// 재고량 있는지 확인
//			if (stockInfo.get(product.getProductId()) > 0) {
//				// 재고량과 출고량 비교
//				if (stockInfo.get(product.getProductId()) >= info.getProductAmount()) {
//					// -1 조건을 모두 만족하는 경우 출고처리
//					History history = new History();
//					history.setProductId(product.getProductId());
//					history.setProductCategory(2);
//					history.setProductAmount(info.getProductAmount());
//					
//					hDao.insert(history);
//				}
//				// -2 각 조건이 만족되지 않는 경우 적합한 문구를 출력
//				else {
//					System.out.println("출고량이 재고량을 초과합니다.");
//				}
//			}
//			else {
//				System.out.println("재고량이 0입니다.");
//			}
//		}
//		else {
//			System.out.println("해당 제품의 정보를 확인해주세요.");
//		}
	}
	
	// 제품재고조회
	private void productStock() {
		// 검색
		String productName = inputName();
		//등록된 제품인지 확인
		Product product = pDao.selectOne(productName);
		
		if (product == null) {
			System.out.println("해당 제품의 정보가 등록되어있지 않습니다.");
			return;
		}
		// 해당 제품의 재고 출력
		int stock = selectStock(product.getProductId());
		
		System.out.println("제품번호 : " + product.getProductId() +
							", 제품이름 : " + product.getProdctName() +
							", 재고 : " + stock);
	}
	
	// 전체제품재고조회
	private void allProductStock() {
		Map<Integer, Integer> map = hDao.selectAllAmount();
		Set<Integer> productIdList = map.keySet();
		for (int productId : productIdList) {
			String prodctName = pDao.selectOne(productId).getProdctName();
			int stock = map.get(productId);
			
			System.out.println("제품번호 : " + productId +
							", 제품이름 : " + prodctName +
							", 재고 : " + stock);
		}
	}
	
	//// 부가 메서드
	// 제품 정보 입력
	private Product inputProductInfo() {
		Product product = new Product();
		System.out.print("제품이름 >> ");
		product.setProdctName(sc.nextLine());
		System.out.print("제품가격 >> ");
		product.setProductPrice(Integer.parseInt(sc.nextLine()));
		
		return product;
	}
	
	// 제품 수량 입력
	private Info inputAmountInfo() {
		Info info = new Info();
		System.out.print("제품이름 >> ");
		info.setProductName(sc.nextLine());
		System.out.print("제품수량 >> ");
		info.setProductAmount(Integer.parseInt(sc.nextLine()));
		
		return info;
	}
	
	// 제품 이름 입력
	private String inputName() {
		System.out.print("제품이름 >> ");
		return sc.nextLine();
	}
	
	// 특정 아이디의 제품재고
	private int selectStock(int productId) {
		// 내 코드
		Integer stock = hDao.selectAllAmount().get(productId);
		if (stock == null) {
			stock = 0;
		}
		return stock;
		
//		// 교수님 코드
//		int in = hDao.selectInAmount(productId);
//		int out = hDao.selectOutAmount(productId);
//		
//		return (in - out);
				
	}
	
}
