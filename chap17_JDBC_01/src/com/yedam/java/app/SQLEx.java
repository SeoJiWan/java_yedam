package com.yedam.java.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * PreparedStatement --> insert 시 파라미터에 물음표를 넣으면 됨 
 */

public class SQLEx {
	
	public static void main(String[] args) throws Exception {
		
		// 1. JDBC Driver 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 2. DB 서버 접속
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pwd = "hr";
		Connection con = DriverManager.getConnection(url, id, pwd);
		
		// 3. CRUD 실행
		// 3-1. ------ insert ------
			// -1. Statement or PreparedStatement 객체 생성
		String insert = "INSERT INTO employees VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(insert);
			// -2. SQL 구성 후 실행
		pstmt.setInt(1, 1000); // setInt(int parameter(?) idx, int x)
		pstmt.setString(2, "Kil-Dong");
		pstmt.setString(3, "Hong");
		pstmt.setString(4, "hongkd@");
		pstmt.setString(5, "192.333.444.3");
		pstmt.setString(6, "21/11/05");
		pstmt.setString(7, "SA_REP");
		pstmt.setInt(8, 6000);
		pstmt.setDouble(9, 0.15);
		pstmt.setInt(10, 149);
		pstmt.setInt(11, 80);
			// -3. 결과 출력
		int result = pstmt.executeUpdate();
		System.out.println("insert 결과 : " + result);
		
		// 3-2. ------ update ------
			// -1. Statement or PReparedStatement 객체 생성
		String update = "UPDATE employees SET last_name = ? where employee_id = ?"; // ? 는 값만 대체 가능
		pstmt = con.prepareStatement(update);
			// -2. SQL 구성 후 실행
		pstmt.setString(1, "KKKKK");
		pstmt.setInt(2, 1000);
			// -3. 결과 출력
		result = pstmt.executeUpdate();
		System.out.println("update 결과 : " + result);
				
		// 3-3. ------ select ------
			// -1. Statement or PReparedStatement 객체 생성
		String select = "SELECT * FROM employees ORDER BY employee_id";
		pstmt = con.prepareStatement(select);
			// -2. SQL 구성 후 실행
		ResultSet rs = pstmt.executeQuery();
			// -3. 결과 출력
		int cnt = 0;
		while (rs.next()) {
			cnt += 1;
			String info = rs.getInt("employee_id") + " : " + rs.getString("last_name");
			System.out.println(info);
		}
		System.out.println(cnt);
		
		// 3-4. ------ delete ------
			// -1. Statement or PReparedStatement 객체 생성
		String delete = "DELETE FROM employees WHERE employee_id = ?"; // ? 는 값만 대체 가능
		pstmt = con.prepareStatement(delete);
			// -2. SQL 구성 후 실행
		pstmt.setInt(1, 1000);
			// -3. 결과 출력
		result = pstmt.executeUpdate();
		System.out.println("delete 결과 : " + result);
			
		// 4. 자원해제
		rs.close();
		pstmt.close();
		con.close();
	}

}
