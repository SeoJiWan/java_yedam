package com.yedam.java.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptSQLEx {
	
	
	public static void main(String[] args) throws Exception {
//		try {
			// 1. JDBC Driver 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. DB 서버 접속
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "hr";
			String pwd = "hr";
			
			Connection conn = DriverManager.getConnection(url, id, pwd);
			
			// 3. CRUD 실행
			
				// ------- insert ------- //
				// -1. PreparedStatment 객체 생성
			String insert = "INSERT INTO departments VALUES (?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(insert);
				// -2. Query 구성 - ? 파라미터 생성
			pstmt.setInt(1, 1000);
			pstmt.setString(2, "DESIGN");
			pstmt.setInt(3, 100);
			pstmt.setInt(4, 1800);
				// -3. 실행 후 결과 출력
			int result = pstmt.executeUpdate();
			System.out.println("insert 실행 : " + result);
				
				// ------- update ------- //
				// -1. PreparedStatment 객체 생성
			String update = "UPDATE departments SET department_name = ? WHERE department_id = ?";
			pstmt = conn.prepareStatement(update);
				// -2. Query 구성
			pstmt.setString(1, "CONTROL");
			pstmt.setInt(2, 1000);
				// -3. 실행 후 결과 출력
			result = pstmt.executeUpdate();
			System.out.println("update 결과 : " + result);
			
				// ------- select ------- //
				// -1. PreparedStatment 객체 생성
			String select = "SELECT * FROM departments ORDER BY department_id";
			pstmt = conn.prepareStatement(select);
				// -2. Query 구성
			ResultSet rs = pstmt.executeQuery();
				// -3. 실행 후 결과 출력
			while (rs.next()) {
				String info = "부서번호 : " + rs.getInt("department_id") 
							+ ", 부서이름 : " + rs.getString("department_name");
				System.out.println(info);
			}
		
				// ------- delete ------- //
				// -1. PreparedStatment 객체 생성
			String delete = "DELETE FROM departments WHERE department_id = ?";
			pstmt = conn.prepareStatement(delete);
				// -2. Query 구성
			pstmt.setInt(1, 1000);
				// -3. 실행 후 결과 출력
			result = pstmt.executeUpdate();
			System.out.println("delete 결과 : " + result);

			// 4. 자원해제
			rs.close();
			pstmt.close();
			conn.close();
			
//		} catch (ClassNotFoundException e) {
//			System.out.println("DB 서버 접속 실패");
//		} catch (SQLException e) {
//			System.out.println("Query 실행 실패");
//		} finally {
//			
//		}
	}

}
