package practice.customerService;

public class Repository {
	
	// 필드
	protected Customer[] dataList;
	protected int listIdx;
	
	
	// 생성자
	protected Repository() {
		dataList = new Customer[100];
		listIdx = -1;
	}
	
	
	//// 메서드
	// 삽입
	protected void insert(Customer customer) {
		dataList[++listIdx] = customer;
	}
	
	// 조회
	protected Customer selectOne(int customerPhoneNum) {
		Customer selectedCustomer = null;
		for (int i = 0; i <= listIdx; i++) {
			if (dataList[i].getCustomerPhoneNum() == customerPhoneNum) {
				selectedCustomer = dataList[i];
			}
		}
		return selectedCustomer;
	}
	
	// 전체조회
	protected Customer[] selectAll() {
		return dataList;
	}
	
	// 수정 --> ########################### 수정필요
	protected void update(int customerPhoneNum, Customer customer) {
		for (int i = 0; i <= listIdx; i++) {
			if (dataList[i].getCustomerPhoneNum() == customer.getCustomerPhoneNum()) {
				dataList[i] = customer;
			}
		}
	}
	
	// 삭제
	protected void delete(int customerPhoneNum) {
		int delIdx = 0;
		for (int i = 0; i <= listIdx; i++) {
			if (dataList[i].getCustomerPhoneNum() == customerPhoneNum) {
				dataList[i] = null;
				delIdx = i;
			}
		}
		
		// 데이터 정리
		for (int i = delIdx; i < listIdx; i++) {
			dataList[i] = dataList[i + 1];
		}
		listIdx--;
	}
	

}
