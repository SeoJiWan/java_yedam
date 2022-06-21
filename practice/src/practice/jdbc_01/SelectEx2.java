package practice.jdbc_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectEx2 {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pwd = "hr";
		
		Connection conn = DriverManager.getConnection(url, id, pwd);
		
		String selectSQL = "SELECT * FROM employees";
		PreparedStatement pstmt = conn.prepareStatement(selectSQL);
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			int empId = rs.getInt(1);
			String name = rs.getString(2) + " " + rs.getString(3);
			double salary = rs.getDouble(8);
			int deptId = rs.getInt(11);
			
			System.out.println(empId + "\t\t" + name + "\t\t" + salary + "\t\t" + deptId);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
	}

}
