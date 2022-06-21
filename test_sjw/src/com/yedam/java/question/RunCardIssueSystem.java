package com.yedam.java.question;

import java.util.Scanner;

public class RunCardIssueSystem {
	
	// 필드
	Scanner sc = new Scanner(System.in);

	
	// 생성자
	public RunCardIssueSystem() {
		
		System.out.print("전원실적 >> ");
		int record = Integer.parseInt(sc.nextLine());
		
		Member member = Member.getMemberShip(record);
		member.showMemberInfo();
		
		// 카드발급
		Payment payment = null;
		if (record >= Member.GRADE_STANDARD) {
			payment = new VIPCard();
		}
		else {
			payment = new GreenCard();
		}
		
		System.out.println("=== 등급에 따른 카드 사용시 결제 예상금액 ===");
		System.out.print("사용할 금액 >> ");
		int price = Integer.parseInt(sc.nextLine());
		System.out.println("결제방법 : 1.오프라인 (1% sale), 2.온라인 (3% sale), 3.간편결제 (5% sale)");
		System.out.print("선택 >> ");
		int paymentSelect = Integer.parseInt(sc.nextLine());
		
		if (paymentSelect == 1) {
			int offlinePrice = payment.offline(price);
			System.out.println("결제 예상 금액 : " + offlinePrice);
			payment.showCardInfo();
		}
		else if (paymentSelect == 2) {
			int onlinePrice = payment.online(price);
			System.out.println("결제 예상 금액 : " + onlinePrice);
			payment.showCardInfo();
		}
		else if (paymentSelect == 3) {
			int simplePrice = payment.simple(price);
			System.out.println("결제 예상 금액 : " + simplePrice);
			payment.showCardInfo();
		}
	}
	
	
	
	
}
