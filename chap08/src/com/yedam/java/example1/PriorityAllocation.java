package com.yedam.java.example1;

// 우선순위에 따라서 베테랑 직원에게 우선 배분
public class PriorityAllocation implements Scheduler{

	@Override
	public void getNextCall() {
		System.out.println("고객 등급이 높은 고객의 전화를 먼저 가져옵니다.");
	}

	@Override
	public void sendCallToAgent() {
		System.out.println("업무 스킬이 높은 상담원에게 우선적으로 배분합니다.");
	}

}
