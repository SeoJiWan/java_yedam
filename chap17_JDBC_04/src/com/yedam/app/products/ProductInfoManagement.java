package com.yedam.app.products;

import java.util.List;

import com.yedam.app.common.LogInControl;

public class ProductInfoManagement extends Management{
	
	public ProductInfoManagement() { // 부모클래스인 Management 생성자도 호출함 
		
		boolean role = selectRole();
		
		while(true) {
			printMenu(role);
			
			int menuNo = selectMenu();
			
			if (menuNo == 1 && role) {
				// 제품정보등록
				insertProInfo();
			}
			else if(menuNo == 2 && role) {
				// 제품정보수정 - 가격
				updateProInfo();
			}
			else if (menuNo == 3 && role) {
				// 제품정보삭제
				deleteProInfo();
			}
			else if (menuNo == 4) {
				findProInfo();
			}
			else if (menuNo == 5) {
				findAllProInfo();
			}
			else if (menuNo == 9) {
				// 뒤로가기
				back();
				break;
			}
			else {
				showInputError();
			}
		}
	}


	protected void printMenu(boolean role) {
		System.out.println("============================================================");
		String menu = "";
		if (role) {
			menu += "1.제품등록 | 2.제품수정 | 3.제품삭제 | ";
		}
		menu += "4.제품검색 | 5.전체조회 | 9.뒤로가기";
		System.out.println(menu);
		System.out.println("============================================================");
	}
	
	private void back() {
		System.out.println("뒤로 돌아갑니다.");
	}
	
	private void insertProInfo() {
		// 제품정보 입력
		Product product = inputAll();
		
		// DB에 저장
		pDAO.insert(product);
	}
	
	private void deleteProInfo() {
		// 제품이름 입력
		String productName = inputName();
		
		// 제품정보 검색
		// -1. products 테이블에서 정보
		Product product = pDAO.selectOne(productName);
		if (product == null) {
			System.out.println("등록된 정보가 없습니다.");
			return;
		}
		// -2. 입고내역에서 검색
		boolean isSelected = rDAO.selectInfo(product.getProductId());
		
		// DB에서 삭제
		if (!isSelected) {
			pDAO.delete(product.getProductId());
		}
	}
	
	private void updateProInfo() {
		// 제품이름 입력
		String productName = inputName();
		
		// 제품정보 검색
		Product product = pDAO.selectOne(productName);
		
		if (product == null) {
			System.out.println("등록된 정보가 없습니다.");
			return;
		}
		
		// 수정할 정보 입력
		product = inputUpdateInfo(product);
		
		// DB 수정
		pDAO.updateInfo(product);
	}
	
	private Product inputAll() {
		Product product = new Product();
		
		System.out.print("제품이름 >> ");
		product.setProductName(sc.nextLine());
		System.out.print("제품가격 >> ");
		product.setProductPrice(Integer.parseInt(sc.nextLine()));
		
		return product;
	}
	
	private String inputName() {
		System.out.print("제품이름 >> ");
		return sc.nextLine();
	}
	
	private Product inputUpdateInfo(Product product) {
		System.out.println("기존 > " + product.getProductName());
		System.out.print("수정 (수정하지 않을 경우 0 입력) > ");
		String name = sc.nextLine();
		if(!name.equals("0")) {
			product.setProductName(name);
		}
		
		System.out.println("기존 > " + product.getProductPrice());
		System.out.print("수정 (수정하지 않을 경우 0 입력) > ");
		int price = Integer.parseInt(sc.nextLine());
		if(!name.equals("0")) {
			product.setProductPrice(price);
		}
		
		return product;
	}
	
	private void findProInfo() {
		String productName = inputName();
		
		Product product = pDAO.selectOne(productName);
		
		if (product == null) {
			System.out.println("등록된 제품이 아닙니다.");
			return;
		}
		
		System.out.println(product);
	}
	
	private void findAllProInfo() {
		List<Product> list = pDAO.selectAll();
		list.forEach(System.out::println);
	}
	
	private boolean selectRole() {
		int role = LogInControl.getLogIN().getMemberRole();
		if (role == 0) {
			return true;
		}
		else {
			 return false;
		}
	}
	
	

}
