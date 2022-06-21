package chap07.com.yedam.java.example1;

import java.util.Scanner;

public class CustomerSystem {

	// 필드
	private Repository repository = new Repository();
	private Scanner sc = new Scanner(System.in);

	// 생성자
	public CustomerSystem() {
		while (true) {
			// 메뉴 출력
			menuPrint();
			// 메뉴 선택
			int menuNo = menuSelect();
			// 메뉴1 - 회원가입
			if (menuNo == 1) {
				signUp();
			}

			// 메뉴2 - 회원정보 조회
			else if (menuNo == 2) {
				myPage();
			}

			// 메뉴3 - 결제 금액
			else if (menuNo == 3) {
				payInfo();
			}
			
			// 메뉴4 - 종료
			else if (menuNo == 4) {
				exit();
				break;
			}

		}
	}

	// 메서드
	void menuPrint() {
		System.out.println("--------------------------------------");
		System.out.println("1.회원가입 | 2.회원정보 | 3.결제금액 | 4. 종료");
		System.out.println("--------------------------------------");
	}
	
	int menuSelect() {
		System.out.print("메뉴 >> ");
		return Integer.parseInt(sc.nextLine());
	}
	
	void signUp() {
		// 회원 정보 입력
		Customer info = inputCustomerInfo();
		// 가입
		repository.insert(info);
	}
	
	Customer inputCustomerInfo() {
		// 등급선택
		int rank = selectRank();
		
		System.out.print("아이디 >> ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.print("이름 >> ");
		String name = sc.nextLine();
		
		Customer customer = null;
		switch(rank) {
		case 1:
			customer = new Customer(id, name);
			break;
		case 2: 
			customer = new Gold(id, name);
			break;
		case 3: 
			customer = new Vip(id, name, "Tami");
			break;
		}
		
		return customer;
	}
	
	int selectRank() {
		System.out.println("--------------------------");
		System.out.println("1.SILVER | 2.GOLD | 3.VIP");
		System.out.println("--------------------------");
		System.out.print("선택 >> ");
		return Integer.parseInt(sc.nextLine());
	}
	
	void myPage() {
		int customerId = inputOne();
		Customer info = repository.selectOne(customerId);
		System.out.println(info.showInfo());
	}
	
	void payInfo() {
		int customerId = inputOne();
		Customer info = repository.selectOne(customerId);
		
		System.out.print("구매 금액 >> ");
		int price = Integer.parseInt(sc.nextLine());
		int pay = info.calcPrice(price);
		System.out.println("결제 금액 : " + pay);
	}
	
	void exit() {
		System.out.println("프로그램 종료");
	}
	
	int inputOne() {
		System.out.print("고객 아이디 >> ");
		return Integer.parseInt(sc.nextLine());
	}

}
