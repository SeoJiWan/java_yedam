package com.yedam.java.ch1101;

public class Member {
	
	public String id;
	

	/**
	 * @param id
	 */
	public Member(String id) {
		this.id = id;
	}


	@Override
	public boolean equals(Object obj) {
		// 논리적으로 동등한지 --> 다른 객체라도 타입과 내부가 같으면 똑같다고 인지
		
		// 1. 동일한 타입인지
		if (obj instanceof Member) {
			// 2. 내부 필드 값이 같은지
			Member member = (Member) obj;
			if (this.id.equals(member.id)) {
				return true;
			}
		}
		return false;
	}

	
	public static void main(String[] args) {
		Member member1 = new Member("123");
		Member member2 = new Member("123");
		
		if (member1.equals(member2)) {
			System.out.println("dlfjas");
		}
		
	}



	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public String toString() {
		return "Member [id = " + id + "]";
	}
	
	
	
	

}
