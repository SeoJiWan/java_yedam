package com.yedam.java.emp;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class EmpSystem {

	/*
	 * 필드
	 */
	private EmpDAO dao = EmpDAO.getEmpDAO();
	private Scanner sc = new Scanner(System.in);

	/*
	 * 생성자
	 */
	public EmpSystem() {
		
		while (true) {
			// 메뉴 출력
			menuPrint();

			// 메뉴 입력
			int menuNo = selectMenu();

			// 각 기능별 실행
			if (menuNo == 1) {
				// 등록
				insertEmployee();
			} else if (menuNo == 2) {
				// 수정
				updateEmployee();
			} else if (menuNo == 3) {
				// 삭제
				deleteEmployee();
			} else if (menuNo == 4) {
				// 사원조회 (단건조회)
				selectOneEmployee();
			} else if (menuNo == 5) {
				// 사원 전체조회
				selectAllEmployee();
			} else if (menuNo == 9) {
				exit();
				break;
			} else {
				inputError();
			}
			
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
		System.out.println("1.등록 | 2.수정 | 3.삭제 | 4.사원조회 | 5.사원전체조회 | 9.종료");
		System.out.println("====================================================");
		System.out.print("선택 >> ");
	}
	
	// 메뉴입력
	private int selectMenu() {
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
	private void insertEmployee() {
		// 사원정보 입력
		Employee emp = inputAll();
		
		// DB에 전달
		dao.insert(emp);
	}
	
	// 수정
	private void updateEmployee() {
		// 수정할 정보 입력
		Employee emp = inputUpdateInfo();
		
		// DB에 전달
		dao.update(emp);
	}
	
	// 삭제
	private void deleteEmployee() {
		// 사원번호 입력
		int employeeId = inputEmployeeId();
		
		// DB에 전달
		dao.delete(employeeId);
	}
	
	// 사원조회
	private void selectOneEmployee() {
		// 사원번호 입력
		int employeeId = inputEmployeeId();
		
		// DB 검색
		Employee emp = dao.selectOne(employeeId);
		
		// 결과출력
		if (emp != null) {
			System.out.println(emp);
		}
		else {
			System.out.println("employeeId " + employeeId + " is not existed !");
		}
	}
	
	// 사원 전체조회
	private void selectAllEmployee() {
		List<Employee> list = dao.selectAll();
		
		list.forEach(System.out::println);
	}
	
	//// 부가 메서드
	// 사원정보 입력 -> 등록
	private Employee inputAll() {
			Employee emp = new Employee();
			
			// 등록할 사원정보 세팅 
			System.out.print("사번 >> ");
			emp.setEmployeeId(Integer.parseInt(sc.nextLine()));
			System.out.print("이름 >> ");
			emp.setFirstName(sc.nextLine());
			System.out.print("성 >> ");
			emp.setLastName(sc.nextLine());
			System.out.print("이메일 >> ");
			emp.setEmail(sc.nextLine());
			System.out.print("전화번호 >> ");
			emp.setPhoneNumber(sc.nextLine());
			System.out.print("입사일(YYYY-MM-DD) >> ");
			emp.setHierDate(Date.valueOf(sc.nextLine()));
			System.out.print("직급 >> ");
			emp.setJobId(sc.nextLine());
			System.out.print("연봉 >> ");
			emp.setSalary(Double.parseDouble(sc.nextLine()));
			System.out.print("상여 >> ");
			emp.setCommissionPCT(Double.parseDouble(sc.nextLine()));
			System.out.print("상사사번 >> ");
			emp.setManagerId(Integer.parseInt(sc.nextLine()));
			System.out.print("부서번호 >> ");
			emp.setDepartmentId(Integer.parseInt(sc.nextLine()));
			
			return emp;
		}

	// 수정할 사원정보 입력 -> 수정
	private Employee inputUpdateInfo() {
		Employee emp = new Employee();
		
		// 수정할 사원정보 세팅
		System.out.print("사번 >> ");
		emp.setEmployeeId(Integer.parseInt(sc.nextLine()));
		System.out.print("연봉 >> ");
		emp.setSalary(Double.parseDouble(sc.nextLine()));
		
		return emp;
	}
	
	// 사원번호 입력 -> 삭제, 사원조회
	private int inputEmployeeId() {
		System.out.print("사번 >> ");
		return Integer.parseInt(sc.nextLine());
	}
}
