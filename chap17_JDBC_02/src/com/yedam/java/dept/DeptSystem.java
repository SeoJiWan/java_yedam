package com.yedam.java.dept;

import java.util.List;
import java.util.Scanner;

public class DeptSystem {

	/*
	 * 필드
	 */
	private DeptDAO dao = DeptDAO.getDeptDAO();
	private Scanner sc = new Scanner(System.in);

	/*
	 * 생성자
	 */
	public DeptSystem() {

		try {

			while (true) {

				menuPrint();

				int menuNo = menuSelect();

				if (menuNo == 1) {
					insertDept();
				} else if (menuNo == 2) {
					updateDept();
				} else if (menuNo == 3) {
					deleteDept();
				} else if (menuNo == 4) {
					selectOneDept();
				} else if (menuNo == 5) {
					selectAllDept();
				} else if (menuNo == 9) {
					exit();
					break;
				} else {
					inputError();
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("wrong input");
		}
	}

	/*
	 * 메서드
	 */
	//// 주요 메서드
	// 메뉴출력
	private void menuPrint() {
		System.out.println();
		System.out.println("====================================================");
		System.out.println("1.등록 | 2.수정 | 3.삭제 | 4.부서조회 | 5.부서전체조회 | 9.종료");
		System.out.println("====================================================");
		System.out.print("선택 >> ");
	}

	// 메뉴입력
	private int menuSelect() {
		int menu = 0;
		try {
			menu = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Wrong Input ! Please input number.");
		}
		return menu;
	}

	// 시스템 종료
	private void exit() {
		System.out.println("Programm Exit !");
	}

	// 입력 에러
	private void inputError() {
		System.out.println("Wrong Input ! Please input number in menu bar.");
	}

	// 등록
	private void insertDept() {
		Department dept = inputDeptInfo();

		dao.insert(dept);
	}

	// 수정
	private void updateDept() {
		Department dept = inputDeptUpdateInfo();

		dao.update(dept);
	}

	// 삭제
	private void deleteDept() {
		int departmentId = inputDeptId();

		dao.delete(departmentId);
	}

	// 단건 조회
	private void selectOneDept() {
		int departmentId = inputDeptId();

		Department selectOne = dao.selectOne(departmentId);
		System.out.println(selectOne);
	}

	// 전체 조회
	private void selectAllDept() {
		List<Department> list = dao.selectAll();

		list.forEach(System.out::println);
		System.out.println("부서 개수 : " + list.size());
	}

	//// 부가 메서드
	// 부서삽입정보

	private Department inputDeptInfo() {
		Department dept = new Department();

		System.out.print("부서번호 >> ");
		dept.setDepartmentId(Integer.parseInt(sc.nextLine()));
		System.out.print("부서이름 >> ");
		dept.setDepartmentName(sc.nextLine());
		System.out.print("매니저번호 >> ");
		dept.setManagerId(Integer.parseInt(sc.nextLine()));
		System.out.print("지역번호 >> ");
		dept.setLocationId(Integer.parseInt(sc.nextLine()));

		return dept;
	}

	// 부서수정정보
	private Department inputDeptUpdateInfo() {
		Department dept = new Department();

		System.out.print("부서번호 >> ");
		dept.setDepartmentId(Integer.parseInt(sc.nextLine()));
		System.out.print("지역번호 >> ");
		dept.setLocationId(Integer.parseInt(sc.nextLine()));

		return dept;
	}

	// 부서번호 입력
	private int inputDeptId() {
		System.out.print("부서번호 >> ");
		return Integer.parseInt(sc.nextLine());
	}

}
