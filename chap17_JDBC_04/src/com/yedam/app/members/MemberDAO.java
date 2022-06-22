package com.yedam.app.members;

import java.sql.SQLException;

import com.yedam.app.common.DAO;

public class MemberDAO extends DAO{

	/*
	 * Field
	 */
	private static MemberDAO memberDAO;

	
	/*
	 * Constructor
	 */
	private MemberDAO() {}

	
	/*
	 * Method
	 */
	public static MemberDAO getMemberDAO() {
		if (memberDAO == null) {
			memberDAO = new MemberDAO();
		}
		return memberDAO;
	}
	
	// CRUD
	public Member selectOne(Member member) {
		Member logIn = null;
		
		try {
			connect();
			
			String sql = "SELECT * FROM members WHERE member_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getMemberId());
			
			rs = ps.executeQuery();
			
			// 아이디 존재
			if (rs.next()) {
				// 비밀번호 일치
				if (rs.getString("member_pwd").equals(member.getMemberPwd())) {
					logIn = new Member();
					logIn.setMemberId(rs.getString(1));
					logIn.setMemberPwd(rs.getString(2));
					logIn.setMemberRole(rs.getInt(3));
				}
				else {
					System.out.println("비밀번호가 틀립니다.");
				}
			}
			else {
				System.out.println("아이디가 존재하지 않습니다.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return logIn;
	}
}
