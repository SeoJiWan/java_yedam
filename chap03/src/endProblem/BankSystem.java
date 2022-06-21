package endProblem;

import java.util.Scanner;

public class BankSystem {
	
	public static void main(String[] args) {
		
		boolean run = true;
		int balance = 0;
		Scanner sc = new Scanner(System.in);
		
		while (run) {
			System.out.println("-----------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-----------------------------");
			System.out.print("선택 >> ");
			
			int userSelect = sc.nextInt();
			
			System.out.println();
			
			if (userSelect == 1) {
				System.out.println("예금 서비스입니다.");
				System.out.print("입금할 금액을 입력하세요 : ");
				int deposit = sc.nextInt();
				
				System.out.println();
				System.out.printf("%d 원 입금합니다.", deposit);
				System.out.println();
				balance += deposit;
			}
			
			else if (userSelect == 2) {
				System.out.println("출금 서비스입니다.");
				System.out.print("출금할 금액을 입력하세요 : ");
				int withdraw = sc.nextInt();
				
				System.out.println();
				balance -= withdraw;
				if (balance < 0) {
					balance += withdraw;
					System.out.println("잔액이 부족합니다. 현재 잔액 : " + balance);
				}
				else {
					System.out.printf("%d 원 출금합니다.", withdraw);
					System.out.println();
				}
			}
			
			else if (userSelect == 3) {
				
				System.out.println("현재 잔액 : " + balance + " 원");
				System.out.println();
			}
			
			else if (userSelect == 4) {
				System.out.println("서비스를 종료합니다.");
				break;
			}
			
			else {
				System.out.println("잘못된 입력입니다.");
				System.out.println("잘못된 입력입니다.");
				continue;
			}
			
		}
	}

}
