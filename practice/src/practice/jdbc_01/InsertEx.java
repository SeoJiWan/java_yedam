package practice.jdbc_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertEx {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pwd = "hr";
		
		Connection conn = DriverManager.getConnection(url, id, pwd);
		
		String insertSQL = "INSERT INTO employees VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement pstmt = conn.prepareStatement(insertSQL);
		pstmt.setInt(1, 1000);
		pstmt.setString(2, "Seo");
		pstmt.setString(3, "Jiwan");
		pstmt.setString(4, "wana1997");
		pstmt.setString(5, "010.3880.6637");
		pstmt.setString(6, "21/09/13");
		pstmt.setString(7, "SA_REP");
		pstmt.setInt(8, 4000);
		pstmt.setDouble(9, 0.2);
		pstmt.setInt(10, 201);
		pstmt.setInt(11, 110);
		
		int rs = pstmt.executeUpdate();
		
		System.out.println(rs + "행이 삽입되었습니다.");
		
		pstmt.close();
		conn.close();
		
	}

}
