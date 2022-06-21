package com.yedam.java.example1;

// 고객 관리 정책
public interface Scheduler {
	
	// 직원이 고객을 할당받는 방식
	public void getNextCall();
	
	// 관리자가 직접 대기열을 관리
	public void sendCallToAgent();

}
