package com.yedam.app.common;

import java.util.Scanner;

import com.yedam.app.members.Member;
import com.yedam.app.members.MemberDAO;
import com.yedam.app.products.Management;

public class LogInControl {
	
	/*
	 * Field
	 */
	private static Member logIn = null;
	private Scanner sc = new Scanner(System.in);
	private MemberDAO mdao = MemberDAO.getMemberDAO(); 
	

	/*
	 * Constructor
	 */
	public LogInControl() {
		while (true) {
			printMenu();
			
			int menuNo = selectMenu();
			
			if(menuNo == 1) {
				// 로그인
				logIn();
			}
			else if (menuNo == 2) {
				// 종료
				exit();
				break;
			}
			else {
				showInputError();
			}
		}
	}

	/*
	 * Method
	 */
	// 한번 로그인 하면 로그아웃전까지 유지 -> 로깅 클래스로 처리
	public static Member getLogIN() {
		return logIn;
	}
	
	private void printMenu() {
		System.out.println("===============");
		System.out.println("1.로그인 | 2.종료");
		System.out.println("===============");
	}
	
	private int selectMenu() {
		System.out.print("선택 >> ");
		return Integer.parseInt(sc.nextLine());
	}
	
	private void exit() {
		System.out.println("프로그램을 종료합니다.");
	}
	
	private void showInputError() {
		System.out.println("메뉴를 확인하세요.");
	}
	
	private void logIn() {
		// 아이디와 비밀번호 입력
		Member inputInfo = inputMember();
		// 로그인 시도
		logIn = mdao.selectOne(inputInfo);
		
		// 실패할 경우 그대로 메서드 종료
		if (logIn == null) {
			System.out.println("### 로그인 실패! ###");
			return;
		}
		// 성공할 경우 프로그램 실행
		else {
			System.out.println("### 로그인 성공! ###");
			new Management().run();
		}
	}
	
	private Member inputMember() {
		Member member = new Member();
		
		System.out.print("아이디 >> ");
		member.setMemberId(sc.nextLine());
		System.out.print("비밀번호 > ");
		member.setMemberPwd(sc.nextLine());
		
		return member;
	}

}
