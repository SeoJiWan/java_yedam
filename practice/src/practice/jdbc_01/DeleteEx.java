package practice.jdbc_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteEx {

	public static void main(String[] args) throws Exception {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pwd = "hr";
		
		Connection conn = DriverManager.getConnection(url, id, pwd);
		
		String deleteSQL = "DELETE FROM employees WHERE employee_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(deleteSQL);
		pstmt.setInt(1, 1000);
		
		int rs = pstmt.executeUpdate();
		
		System.out.println(rs + "행이 삭제되었습니다.");
		
		pstmt.close();
		conn.close();
	}
}
