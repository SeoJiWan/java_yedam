package com.yedam.java.question;

/*
 * 추상메서드가 클래스내에 없는데 사용하는 이유
 * -> Member 라는 클래서로 인스턴스 생성 제한하기 위함
 */
public abstract class Member {
	
	// 필드
	public static int GRADE_STANDARD = 1000000;
	public int record;
	public String grade;
	
	
	/**
	 * @param record
	 */
	public Member(int record) {
		this.record = record;
	}
	
	
	//// 메서드
	// 멤버 정보
	public void showMemberInfo() {
		System.out.println("현재실적은 " + record + "이며, 회원등급은 " + grade + "입니다.");
	}
	
	// 등급 확인
	public static Member getMemberShip(int record) {
		Member member = null;
		// gold
		if (record >= GRADE_STANDARD) {
			member = new Gold(record);
		}
		// silver
		else {
			member = new Silver(record);
		}
		return member;
	}
}
