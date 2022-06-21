package com.yedam.app.products;

import java.util.Scanner;

import com.yedam.app.deal.ReceivingGoodsDAO;

public class Management {
	
	/*
	 * Field
	 */
	protected Scanner sc = new Scanner(System.in);
	protected ProductsDAO pDAO = ProductsDAO.getProductsDAO();
	protected ReceivingGoodsDAO rDAO = ReceivingGoodsDAO.getReceivingGoodsDAO();
	protected ExportGoodsDAO tDAO = ExportGoodsDAO.getExportGoodsDAO(); 
	
	
	/*
	 * Method
	 */
	protected void printMenu() {
		System.out.println("================================");
		System.out.println("1.제품정보관리 | 2.제품재고관리 | 3.종료");
		System.out.println("================================");
	}
	
	protected int selectMenu() {
		int menuNo = 0;
		try {
			menuNo = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return menuNo;
	}
	
	protected void exit() {
		System.out.println("프로그램 종료");
	}
	
	protected void showInputError() {
		System.out.println("입력 에러");
	}
	
	public void run() {
		while(true) {
			printMenu();
			
			int menuNo = selectMenu();
			
			if (menuNo == 1) {
				new ProductInfoManagement();
			}
			else if(menuNo == 2) {
				new ProductStockManagement();
			}
			else if (menuNo == 3) {
				exit();
				break;
			}
			else {
				showInputError();
			}
		}
	}
	

}
