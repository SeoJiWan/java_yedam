package com.yedam.app.products;

import java.util.Scanner;

import com.yedam.app.common.LogInControl;
import com.yedam.app.deal.ExportGoodsDAO;
import com.yedam.app.deal.ReceivingGoodsDAO;

public class Management {
	
	/*
	 * Field
	 */
	protected Scanner sc = new Scanner(System.in);
	protected ProductsDAO pDAO = ProductsDAO.getProductsDAO();
	protected ReceivingGoodsDAO rDAO = ReceivingGoodsDAO.getReceivingGoodsDAO();
	protected ExportGoodsDAO eDAO = ExportGoodsDAO.getExportGoodsDAO(); 
	
	
//	/*
//	 * Method
//	 */
//	protected void printMenu(boolean role) {
//		System.out.println("================================");
//		String menu = "";
//		if (role) {
//			menu += "1.제품정보관리 | ";
//		}
//		menu += "2.제품재고관리 | 3.종료";
//		System.out.println(menu);
//		System.out.println("================================");
//	}
//	
//	protected int selectMenu() {
//		int menuNo = 0;
//		try {
//			menuNo = Integer.parseInt(sc.nextLine());
//		} catch (NumberFormatException e) {
//			e.printStackTrace();
//		}
//		return menuNo;
//	}
//	
//	protected void exit() {
//		System.out.println("프로그램 종료");
//	}
//	
//	protected void showInputError() {
//		System.out.println("입력 에러");
//	}
//	
//	public void run() {
//		
//		boolean role = selectRole(); 
//				
//		while(true) {
//			printMenu(role);
//			
//			int menuNo = selectMenu();
//			
//			if (menuNo == 1 && role) {
//				new ProductInfoManagement();
//			}
//			else if(menuNo == 2) {
//				new ProductStockManagement2();
//			}
//			else if (menuNo == 3) {
//				exit();
//				break;
//			}
//			else {
//				showInputError();
//			}
//		}
//	}
//	
//	private boolean selectRole() {
//		int role = LogInControl.getLogIN().getMemberRole();
//		
//		if (role == 0) {
//			return true;
//		}
//		else {
//			return false;
//		}
//	}
	
	/*
	 * Method
	 */
	protected void printMenu() {
		System.out.println("==================================");
		System.out.println("1.제품정보관리 | 2.제품재고관리 | 9.로그아웃");
		System.out.println("==================================");
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
				new ProductStockManagement2();
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
