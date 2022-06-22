package com.yedam.app.products;

import java.util.List;

import com.yedam.app.deal.DealInfo;

public class ProductStockManagement extends Management {

	/*
	 * Constructor
	 */
	public ProductStockManagement() {
		while (true) {
			printMenu();

			int menuNo = selectMenu();

			if (menuNo == 1) {
				// 입고
				importPro();
			} else if (menuNo == 2) {
				// 입고내역 조회
				findImports();
			} else if (menuNo == 3) {
				// 출고
				exportPro();
			} else if (menuNo == 4) {
				// 출고내역조회
				findExports();
			} else if (menuNo == 9) {
				// 뒤로가기
				back();
				break;
			} else {
				showInputError();
			}

		}
	}

	/*
	 * Method
	 */

	protected void printMenu() {
		System.out.println("=======================================================");
		System.out.println("1.입고 | 2.입고내역조회 | 3.출고 | 4.출고내역조회 | 9.뒤로가기");
		System.out.println("=======================================================");
	}

	private void importPro() {
		DealInfo dealInfo = inputDealInfo();
		
		Product product = pDAO.selectOne(dealInfo.getProductId());
		product.setProductStock(product.getProductStock() + dealInfo.getProductAmount());

		rDAO.insert(dealInfo);
		pDAO.updateStock(product);
	}

	private void exportPro() {
		DealInfo dealInfo = inputDealInfo();
		
		Product product = pDAO.selectOne(dealInfo.getProductId());
		product.setProductStock(product.getProductStock() - dealInfo.getProductAmount());


		eDAO.insert(dealInfo);
		pDAO.updateStock(product);
	}
	
	private void findImports() {
		List<DealInfo> list = rDAO.selectAll();
		list.forEach(System.out::println);
	}
	
	private void findExports() {
		List<DealInfo> list = eDAO.selectAll();
		list.forEach(System.out::println);
	}
	
	private void back() {
		System.out.println("뒤로 돌아갑니다.");
	}
	
	private DealInfo inputDealInfo() {
		DealInfo info = new DealInfo();
		
		System.out.print("제품번호 >> ");
		info.setProductId(Integer.parseInt(sc.nextLine()));
		System.out.print("제품수량 >> ");
		info.setProductAmount(Integer.parseInt(sc.nextLine()));
		
		return info;
	}

}
