package com.yedam.app.members;

public class Member {
	
	/*
	 * Field
	 */
	private String memberId;
	private String memberPwd;
	private int memberRole; // 0:관리자, 1:사용자

	
	/*
	 * Method
	 */
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPwd() {
		return memberPwd;
	}
	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	public int getMemberRole() {
		return memberRole;
	}
	public void setMemberRole(int memberRole) {
		this.memberRole = memberRole;
	}
	@Override
	public String toString() {
		if (memberRole == 0) {
			return "관리자계정 memberId=" + memberId;
		}
		else {
			return "일반계정 memberId=" + memberId;
		}
	}
	

	

}
