package practice.jdbc_03_product;

import java.util.Map;
import java.util.Scanner;

import practice.jdbc_03_product.history.History;
import practice.jdbc_03_product.history.HistoryDAO;
import practice.jdbc_03_product.product.Product;
import practice.jdbc_03_product.product.ProductDAO;

public class StockManager {

	/*
	 * Field
	 */
	private Scanner sc = new Scanner(System.in);
	private ProductDAO pDAO = ProductDAO.getProductDAO();
	private HistoryDAO hDAO = HistoryDAO.getHistoryDAO();

	/*
	 * Constructor
	 */
	public StockManager() {

		while (true) {

			printMenu();

			int userInput = selectMenu();

			if (userInput == 1) {
				// register a product
				insertProduct();
			} else if (userInput == 2) {
				// receiving the product
				importProduct();
			} else if (userInput == 3) {
				// release a product
				exportProduct();
			} else if (userInput == 4) {
				// check the stock of a particular product
				checkStockByName();
			} else if (userInput == 5) {
				// check the stock of all products
				checkAllStock();
			} else if (userInput == 9) {
				// exit the program
				exit();
			} else {
				// input error
				showInputError();
			}
		}
	}

	
	/*
	 * Method
	 */
	//// 주요 메서드
	// 메뉴출력
	private void printMenu() {
		System.out.println("===========================================================");
		System.out.println("1.제품등록 | 2.입고 | 3.출고 | 4.제품재고조회 | 5. 전체재고조회 | 9.종료");
		System.out.println("===========================================================");
	}
	
	// 메뉴선택
	private int selectMenu() {
		System.out.print("선택 >> ");
		return Integer.parseInt(sc.nextLine());
	}
	
	// 제품등록
	private void insertProduct() {
		Product product = insertProductInfo();
		
		pDAO.insert(product);
	}
	
	// 제품입고
	private void importProduct() {
		// 입고할 제품 정보 입력
		History history = productInfo();
		
		// 입고처리
		hDAO.insert(history);
	}
	
	// 제품출고
	private void exportProduct() {
		// 출고할 제품 정보 입력
		History history = productInfo();
		history.setProductCategory("EX");
		
		// 재고 확인 (현 재고보다 작아야 함)
		Integer presentStock = hDAO.selectAllAmount().get(history.getProductId());
		int exportStock = history.getProductAmount();
		if (exportStock <= presentStock) {
			// 출고 처리
			hDAO.insert(history);
		}
		else {
			System.out.println("출고량이 재고량을 초과합니다. (재고 : " + presentStock + ")");
		}
	}
	
	// 제품이름으로 재고 조회
	private void checkStockByName() {
		System.out.print("제품이름 >> ");
		Product product = pDAO.selectOne(sc.nextLine());
		Integer stock = hDAO.selectAllAmount().get(product.getProductId());
		
		System.out.println("제품번호 : " + product.getProductId() 
						+ ", 제품이름 : " + product.getProductName()
						+ ", 제품가격 : " + product.getProductPrice()
						+ ", 제품재고 : " + stock); 
	}
	
	// 전체 제품 재고 조회
	private void checkAllStock() {
		Map<Integer, Integer> map = hDAO.selectAllAmount();
		
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			Integer key = entry.getKey();
			Integer val = entry.getValue();
			
			Product product = pDAO.selectOne(key);
			
			System.out.println("제품번호 : " + product.getProductId() 
							+ "\t\t제품이름 : " + product.getProductName()
							+ "\t\t제품가격 : " + product.getProductPrice()
							+ "\t\t제품재고 : " + val); 
		}
	}
	
	// 시스템 종료
	private void exit() {
		System.out.println("시스템을 종료합니다.");
	}
	
	// 입력 에러
	private void showInputError() {
		System.out.println("메뉴를 참고하여 입력해주세요.");
	}
	
	
	//// 부가메서드
	
	private Product insertProductInfo() {
		Product product = new Product();
		System.out.print("제품이름 >> ");
		product.setProductName(sc.nextLine());
		System.out.print("제품가격 >> ");
		product.setProductPrice(Integer.parseInt(sc.nextLine()));
		
		return product;
	}
	
	// 제품정보입력
	private History productInfo() {
		History history = new History();
		
		try {
			System.out.print("제품이름 >> ");
			history.setProductId(pDAO.selectOne(sc.nextLine()).getProductId());
			history.setProductCategory("IN");
			System.out.print("제품수량 >> ");
			history.setProductAmount(Integer.parseInt(sc.nextLine()));
		} catch (NullPointerException e) {
			System.out.println("해당 제품을 먼저 등록하세요.");
		}
		
		return history;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
