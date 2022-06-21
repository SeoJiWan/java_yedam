package chap07.com.yedam.java.example1;

import java.awt.MultipleGradientPaint.CycleMethod;

/*
 * 고객정보 저장하는 저장소
 */
public class Repository {

	private Customer[] dataList;
	private int listIdx;

	public Repository() {
		dataList = new Customer[100];
		listIdx = -1;
	}

	// 등록
	public void insert(Customer customer) {
		dataList[++listIdx] = customer;
	}

	// 수정
	public void update(Customer customer) {
		for (int i = 0; i <= listIdx; i++) {
			if (dataList[i].getCustomerId() == customer.getCustomerId()) {
				dataList[i] = customer;
			}
		}
	}

	// 삭제
	public void delete(int customerId) {
		int delIdx = 0;
		// 해당 데이터 삭제
		for (int i = 0; i <= listIdx; i++) {
			if (dataList[i].getCustomerId() == customerId) {
				dataList[i] = null;
				delIdx = i;
			}
		}
		
		// 데이터 정리
		cleanDataList();

//		// 데이터 정리
//		for (int i = delIdx; i < listIdx; i++) {
//			dataList[i] = dataList[i + 1];
//		}

	}

	// 데이터 정리
	private void cleanDataList() {
		// 데이터 정리
		Customer[] temp = dataList;
		int tempIdx = listIdx;

		this.dataList = new Customer[100];
		this.listIdx = -1;
		for (int i = 0; i < tempIdx; i++) {
			if (temp[i] == null) {
				continue;
			}
			dataList[++listIdx] = temp[i];
		}
	}
	
	// 전체 조회
	public Customer[] selectAll() {
		return dataList;
	}
	
	// 단일 조회
	public Customer selectOne(int customerId) {
		Customer selceted = null;
		for (int i = 0; i <= listIdx; i++) {
			if (dataList[i].getCustomerId() == customerId) {
				selceted = dataList[i];
				break;
			}
		}
		
		return selceted;
	}
	

}
