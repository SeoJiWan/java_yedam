package practice.customerService;

import java.util.Scanner;

public class CustomerSystem {

	// 필드
	private Repository repository = new Repository();
	private Scanner sc = new Scanner(System.in);

	// 생성자
	public CustomerSystem() {

		while (true) {
			try {
				// 메뉴 출력
				menuPrint();

				// 메뉴 선택
				int menuNo = menuSelect();

				// 메뉴 1 - 회원가입
				if (menuNo == 1) {
					signUp();
				}

				// 메뉴 2 - 회원정보조회
				else if (menuNo == 2) {
					checkCustomerInfo();
				}
				
				// 메뉴 3 - 회원정보조회
				else if (menuNo == 3) {
					checkAllCustomerInfo();
				}

				// 메뉴 4 - 결제 금액, 적립금
				else if (menuNo == 4) {
					checkPayInfo();
				}

				// 메뉴 5 - 회원삭제
				else if (menuNo == 5) {
					deleteCustomerInfo();
				}
				
				// 메뉴 6 - 회원수정
				else if (menuNo == 6) {
					modifyCustomerInfo();
				}

				// 메뉴 7 - 종료
				else if (menuNo == 7) {
					exit();
					break;
				}

				else {
					System.out.println("잘못된 입력입니다.");
				}
			} catch (NumberFormatException e) {
				System.out.println();
				System.out.println("잘못된 입력입니다.");
				System.out.println();
			} catch (NullPointerException e) {
				System.out.println();
				System.out.println("잘못된 입력입니다.");
				System.out.println();
			}
		}
	}

	//// 메서드
	// 메뉴출력
	void menuPrint() {
		System.out.println("-------------------------------------------");
		System.out.println("1.회원가입 | 2.회원정보조회 | 3.결제 | 4. 종료");
		System.out.println("-------------------------------------------");
	}

	// 메뉴선택
	int menuSelect() {
		System.out.print("선택 >> ");
		return Integer.parseInt(sc.nextLine());
	}

	// 회원가입
	void signUp() {
		repository.insert(inputCustomerInfo());
	}

	// 등급선택
	Customer inputCustomerInfo() {
		System.out.println();
		System.out.print("이름 : ");
		String customerName = sc.nextLine();
		System.out.print("전화번호 : ");
		int customerPhoneNum = Integer.parseInt(sc.nextLine());

		System.out.println("--------------------------");
		System.out.println("1.SILVER | 2.GOLD | 3.VIP");
		System.out.println("--------------------------");
		System.out.print("선택 >> ");
		int selectGrade = Integer.parseInt(sc.nextLine());
		System.out.println();

		Customer customer = null;
		switch (selectGrade) {
		case 1:
			customer = new Customer(customerName, customerPhoneNum);
			break;
		case 2:
			customer = new Gold(customerName, customerPhoneNum);
			break;
		case 3:
			customer = new Vip(customerName, customerPhoneNum, "Tami");
			break;
		}
		return customer;
	}

	// 회원정보조회
	void checkCustomerInfo() {
		System.out.println();
		System.out.print("전화번호 >> ");
		int customerPhoneNum = Integer.parseInt(sc.nextLine());

		String CustomerInfo = repository.selectOne(customerPhoneNum).customerInfo();
		System.out.println(CustomerInfo);
		System.out.println();
	}

	// 전체회원정보조회
	void checkAllCustomerInfo() {
		Customer[] allCustomerInfo = repository.selectAll();
		for (int i = 0; i < allCustomerInfo.length; i++) {
			if (allCustomerInfo[i] != null) {
				System.out.println(allCustomerInfo[i].customerInfo());
			}
		}
	}

	// 결제금액조회
	void checkPayInfo() {
		System.out.println();
		System.out.print("전화번호 >> ");
		int customerPhoneNum = Integer.parseInt(sc.nextLine());

		System.out.print("가격 >> ");
		int price = Integer.parseInt(sc.nextLine());

		int pay = repository.selectOne(customerPhoneNum).calcPrice_Accum(price);
		System.out.println("결제 금액 : " + pay);
		System.out.println();
	}

	// 회원삭제
	void deleteCustomerInfo() {
		System.out.println();
		System.out.print("전화번호 >> ");
		int customerPhoneNum = Integer.parseInt(sc.nextLine());

		repository.delete(customerPhoneNum);
		String deleted = repository.selectOne(customerPhoneNum).customerInfo();
		System.out.println(deleted + " 님 회원 삭제되었습니다.");
	}

	// 회원수정
	void modifyCustomerInfo() {
		System.out.println();
		System.out.print("전화번호 >> ");
		int customerPhoneNum = Integer.parseInt(sc.nextLine());
		
		repository.update(customerPhoneNum, inputCustomerInfo());
	}

	// 종료
	void exit() {
		System.out.println("프로그램 종료");
	}

}
