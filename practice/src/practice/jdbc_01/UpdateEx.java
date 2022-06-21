package practice.jdbc_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateEx {
	
	public static void main(String[] args) throws Exception {
		
		// 오라클 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 디비 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pwd = "hr";
		
		Connection conn = DriverManager.getConnection(url, id, pwd);
		
		// sql 작성 및 스테이트먼트 객체 생성 
		String updateSQL = "UPDATE employees SET salary = ? WHERE employee_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(updateSQL);
		pstmt.setInt(1, 9999);
		pstmt.setInt(2, 1000);
		
		// sql 실행 및 결과 확인
		int rs = pstmt.executeUpdate();
		System.out.println(rs + "행이 수정되었습니다.");
		
		// 자원 해제
		pstmt.close();
		conn.close();
	}

}
